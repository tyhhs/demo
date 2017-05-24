package com.netease.tyh.neteaseNosToolDemo2.nos;

import com.netease.tyh.neteaseNosToolDemo2.utils.Constant;
import com.netease.tyh.neteaseNosToolDemo2.utils.HttpUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjtangyunhao on 2017/4/26.
 */
public class NosTools {

    /**
     * 根据nosconfig的配置上传网络图片
     * @param nosConfig
     * @return
     */
    public static String uploadUrlImg(NosConfig nosConfig){
        String url = Constant.NOS_HOST_TEST + Constant.NOS_UPLOAD_ONLINE;
        //参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("bucketName", nosConfig.getBucketName());
        params.put("from", nosConfig.getFrom());
        params.put("docid", nosConfig.getDocid());
        params.put("path", nosConfig.getPath());
        params.put("url", nosConfig.getUrl());
        if(nosConfig.isResize()){
            params.put("resize", "true");
            params.put("rewitdh", Integer.toString(nosConfig.getRewidth()));
        }
        return HttpUtils.sendGet(url, params);
    }

    /**
     * 根据nosconfig的配置上传文件
     * @param nosConfig
     * @return
     */
    public static String uploadImg(NosConfig nosConfig){
        String url = Constant.NOS_HOST_TEST + Constant.NOS_UPLOAD_LOCAL;
        //参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("uploadtype", nosConfig.getUploadtype());
        params.put("bucketName", nosConfig.getBucketName());
        params.put("from", nosConfig.getFrom());
        params.put("imageId", nosConfig.getImageId());
        params.put("path", nosConfig.getPath());
        if(nosConfig.isResize()){
            params.put("resize", "true");
            params.put("rewitdh", Integer.toString(nosConfig.getRewidth()));
        }
        //图片
        Map<String, File> files = new HashMap<String, File>();
        files.put("file", nosConfig.getFile());

        return HttpUtils.sendPost(url, params, files);
    }
}
