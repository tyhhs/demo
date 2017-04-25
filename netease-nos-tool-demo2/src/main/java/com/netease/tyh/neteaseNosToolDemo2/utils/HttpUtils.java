package com.netease.tyh.neteaseNosToolDemo2.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by bjtangyunhao on 2017/4/25.
 */
public class HttpUtils {

    /**
     * 向指定的url发送get请求，返回数据
     * @param url
     * @return
     */
    public static String sendGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        return "";
    }
}
