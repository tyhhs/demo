package com.netease.tyh.neteaseNosToolDemo2.nos;

import com.netease.tyh.neteaseNosToolDemo2.utils.Constant;

import java.io.File;

/**
 * Created by bjtangyunhao on 2017/4/26.
 */
public class NosConfig implements Cloneable {

    public static final NosConfig DEFAULT = new NosConfig.Builder().build();
    private final String url;
    private final String bucketName;
    private final String from;
    private final String path;
    private final boolean resize;
    private final int rewidth;
    private final String docid;
    private final String uploadtype;
    private final File file;
    private final String imageId;
    private final String callback;

    protected NosConfig(){
        this(null, null, null, null, false, 0, null, null, null, null, null);
    }

    private NosConfig(final String url, final String bucketName, final String from, final String path,
              final boolean resize, final int rewidth, final String docid, final String uploadtype,
              final File file, final String imageId, final String callback) {
        super();
        this.url = url;
        this.bucketName = bucketName;
        this.from = from;
        this.path = path;
        this.resize = resize;
        this.rewidth = rewidth;
        this.docid = docid;
        this.uploadtype = uploadtype;
        this.file = file;
        this.imageId = imageId;
        this.callback = callback;
    }

    public String getUrl() {
        return url;
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getFrom() {
        return from;
    }

    public String getPath() {
        return path;
    }

    public boolean isResize() {
        return resize;
    }

    public int getRewidth() {
        return rewidth;
    }

    public String getDocid() {
        return docid;
    }

    public String getUploadtype() {
        return uploadtype;
    }

    public File getFile() {
        return file;
    }

    public String getImageId() {
        return imageId;
    }

    public String getCallback() {
        return callback;
    }

    /**
     * customize builder
     * @return
     */
    public static Builder custom(){
        return new Builder();
    }

    public static class Builder {
        private String url;
        private String bucketName;
        private String from;
        private String path;
        private boolean resize;
        private int rewidth;
        private String docid;
        private String uploadtype;
        private File file;
        private String imageId;
        private String callback;

        public Builder() {
            this.bucketName = Constant.NOS_DEFAULT_BUCKET_NAME;
            this.from = Constant.NOS_FROM;
            this.resize = false;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setBucketName(String bucketName) {
            this.bucketName = bucketName;
            return this;
        }

        public Builder setFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setResize(boolean resize) {
            this.resize = resize;
            return this;
        }

        public Builder setRewidth(int rewidth) {
            this.rewidth = rewidth;
            return this;
        }

        public Builder setDocid(String docid) {
            this.docid = docid;
            return this;
        }

        public Builder setUploadtype(String uploadtype) {
            this.uploadtype = uploadtype;
            return this;
        }

        public Builder setFile(File file) {
            this.file = file;
            return this;
        }

        public Builder setImageId(String imageId) {
            this.imageId = imageId;
            return this;
        }

        public Builder setCallback(String callback) {
            this.callback = callback;
            return this;
        }

        public NosConfig build(){
            return new NosConfig(url, bucketName, from, path,
                    resize, rewidth, docid, uploadtype, file, imageId, callback);
        }

    }


}
