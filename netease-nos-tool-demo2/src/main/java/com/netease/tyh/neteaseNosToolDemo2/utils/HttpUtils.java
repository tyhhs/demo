package com.netease.tyh.neteaseNosToolDemo2.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.james.mime4j.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by bjtangyunhao on 2017/4/25.
 */
public class HttpUtils {
    private static CloseableHttpClient httpClient = null;

    /**
     * 构造httpclient连接池
     */
    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
        // Increase max connections for localhost:80 to 50
        HttpHost localhost = new HttpHost("locahost", 80);
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(100000)
                .setConnectTimeout(100000)
                .setConnectionRequestTimeout(100000)
                .build();

        httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    /**
     * 向指定的url发送get请求，返回数据
     *
     * @param url the url
     * @return string
     */
    public static String sendGet(String url){
        return sendGet(url, null);
    }

    /**
     * 向指定的url发送get请求，带参数，返回数据
     *
     * @param url    the url
     * @param params the params
     * @return string
     */
    public static String sendGet(String url, Map<String,String> params){
        HttpGet httpGet = null;
        boolean success = false;
        String result = "";
        GZIPInputStream gzin = null;
        BufferedReader br = null;
        try{
            if(params != null){
                List<NameValuePair> pairs = new ArrayList<>();
                for(String key : params.keySet()){
                    pairs.add(new BasicNameValuePair(key, params.get(key)));
                }
                String paramStr = EntityUtils.toString(new UrlEncodedFormEntity(pairs, Charset.forName("utf-8")));
                url = url + "?" + paramStr;
            }
            httpGet = new HttpGet(url);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            int httpStatusCode = httpResponse.getStatusLine().getStatusCode();
            //get success
            if(httpStatusCode == HttpStatus.SC_OK){
                HttpEntity httpEntity = httpResponse.getEntity();
                if(httpEntity.getContentEncoding() != null &&
                        httpEntity.getContentEncoding().getValue().toLowerCase().contains("gzip")){
                    String lineSeparator = System.getProperty("line.separator");

                    gzin = new GZIPInputStream(httpEntity.getContent());
                    br = new BufferedReader(new InputStreamReader(gzin));
                    StringBuilder sb = new StringBuilder();
                    String tempBr;
                    while ((tempBr = br.readLine()) != null) {
                        sb.append(tempBr).append(lineSeparator);
                    }
                    result = sb.toString();
                }
                else {
                    result = EntityUtils.toString(httpEntity);
                }
                EntityUtils.consume(httpEntity);
                success = true;
            }
            else {
                System.out.println("网络状态异常" + httpStatusCode);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            IOUtils.closeQuietly(gzin);
            IOUtils.closeQuietly(br);
            if(!success) {
                httpGet.abort();
            }
        }
        return result;
    }

    /**
     * 向url发送post请求，包含参数和文件，返回结果
     * 默认utf-8编码
     *
     * @param url    the url
     * @param params the params
     * @param files  the files
     * @return string
     */
    public static String sendPost(String url, Map<String, String> params, Map<String, File> files){
        return sendPost(url, params, files, "UTF-8");
    }

    /**
     * 向url发送post请求，包含参数和文件，返回结果
     *
     * @param url      the url
     * @param params   the params
     * @param files    the files
     * @param encoding the encoding
     * @return string
     */
    public static String sendPost(String url, Map<String, String> params, Map<String, File> files, String encoding){
        HttpPost httpPost = new HttpPost(url);
        String result = "";
        HttpEntity httpEntity = null;
        boolean success = false;
        try {
            //将参数，文件放入http请求中
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE).setCharset(Charset.forName(encoding));
            //加入参数
            if(params != null){
                for(String key : params.keySet()){
                    multipartEntityBuilder.addPart(key, new StringBody(params.get(key), CharsetUtil.getCharset(encoding)));
                }
            }
            //加入文件
            if(files != null){
                for(String key : files.keySet()){
                    multipartEntityBuilder.addPart(key, new FileBody(files.get(key)));
                }
            }
            httpPost.setEntity(multipartEntityBuilder.build());

            HttpResponse httpResponse = httpClient.execute(httpPost);
            int httpStatus = httpResponse.getStatusLine().getStatusCode();
            if (httpStatus == HttpStatus.SC_OK) {
                httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
                success = true;
            } else {
                result = "网络状态异常:" + httpStatus;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (!success) {
                httpPost.abort();
            }
        }
        return result;
    }
}
