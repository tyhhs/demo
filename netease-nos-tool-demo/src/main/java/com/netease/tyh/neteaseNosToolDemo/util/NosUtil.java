package com.netease.tyh.neteaseNosToolDemo.util;

import com.netease.tyh.neteaseNosToolDemo.util.http.HttpClientUtil;
import com.netease.tyh.neteaseNosToolDemo.util.http.common.HttpConfig;
import com.netease.tyh.neteaseNosToolDemo.util.http.exception.HttpProcessException;
import com.netease.tyh.neteaseNosToolDemo.vo.NosConfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bjtangyunhao on 2017/4/11.
 *
 * NOS服务工具类
 */
public class NosUtil {
    /**
     * 根据参数将网络图片上传到nos服务
     * http get方式
     * @param nosConfig
     * @throws HttpProcessException
     */
    public static Map<String, String> uploadImageByUrl(NosConfig nosConfig) throws Exception {
        HttpConfig httpConfig = HttpConfig.custom();
        StringBuilder uploadUrl = new StringBuilder(Constant.NOS_HOST_TEST + Constant.NOS_UPLOAD_API);
        Map<String, Object> params = EntityUtil.objectToMapWithoutNullValue(nosConfig);
        if(params != null){
            String urlParams = paramsMapToUrlParams(params);
            uploadUrl.append(urlParams);
        }
        httpConfig = httpConfig.url(uploadUrl.toString());
        String resJson =  HttpClientUtil.get(httpConfig);
        return EntityUtil.jsonToMap(resJson);

    }


    /**
     * 生成docId
     * 传入上传人的邮箱
     * 返回邮箱+时间戳
     * @param email
     */
    public static String getDocId(String email){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        // new Date()为获取当前系统时间
        String timeStamp = df.format(new Date());
        return email + "_" + timeStamp;
    }

    public static String paramsMapToUrlParams(Map<String, Object> params){
        StringBuilder urlParams = new StringBuilder("?");
        Iterator<Map.Entry<String, Object>> iter = params.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Object> entry = iter.next();
            try{
                String token = entry.getKey() + "=" + entry.getValue() + "&";
                urlParams.append(token);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return urlParams.toString();
    }
}
