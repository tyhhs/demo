package com.netease.tyh.neteaseNosToolDemo.vo;

import com.netease.tyh.neteaseNosToolDemo.util.Constant;

/**
 * Created by bjtangyunhao on 2017/4/11.
 */
public class NosConfig {

    //nos桶的名字 (默认cms-bucket)
    private String bucketName;

    //业务来源名称  (与开发人员协商名字(联系人：bjwanglong@corp.netease.com))
    private String from;

    /*选填参数*/

    //可以指定nos图片的地址(即http://cms-bucket.nosdn.127.net/+path)
    //若未指定此参数，图片地址待接口返回值json中获取ourl参数即可
    private String path;

    //nos默认返回原图大小，此值为true时，默认返回宽度为550像素原图的等比例压缩后nos图片地址，可以通过下面参数控制返回图片的尺寸
    private boolean resize;

    //在resize=true时,此参数生效，例rewidth=300时 返回图片宽度是300像素的等比例压缩后nos图片地址
    private Integer rewidth;

    //文章发布器使用，传入文章的id
    private String docid;

    //默认resize为false
    public NosConfig(){
        setResize(false);
        setFrom(Constant.NOS_FROM);
        setBucketName(Constant.NOS_DEFAULT_BUCKET_NAME);
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isResize() {
        return resize;
    }

    public void setResize(boolean resize) {
        this.resize = resize;
    }

    public Integer getRewidth() {
        return rewidth;
    }

    public void setRewidth(Integer rewidth) {
        this.rewidth = rewidth;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }
}
