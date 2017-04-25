package com.netease.tyh;

import com.netease.tyh.neteaseNosToolDemo.util.Constant;
import com.netease.tyh.neteaseNosToolDemo.util.NosUtil;
import com.netease.tyh.neteaseNosToolDemo.vo.NosUrlConfig;
import org.junit.Test;

import java.util.Map;

/**
 * Created by bjtangyunhao on 2017/4/11.
 */
public class NosTest {
    @Test
    public void testNosUploadOnline() throws Exception {
        NosUrlConfig nosConfig = new NosUrlConfig();
        nosConfig.setUrl("http://cba.sports.163.com/2016/images/team/big/496.jpg");
        nosConfig.setBucketName(Constant.NOS_DEFAULT_BUCKET_NAME);
        nosConfig.setFrom("sports");
        nosConfig.setPath("sports/cba/player/123456.jpg");
        nosConfig.setDocid(NosUtil.getDocId(Constant.CORP_TYH));
        Map<String, String> response = NosUtil.uploadImageByUrl(nosConfig);
        System.out.println(response.get("ourl"));
    }

    @Test
    public void testNosUpload(){

    }
}
