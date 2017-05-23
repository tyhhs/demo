package com.netease.tyh;

import com.netease.tyh.neteaseNosToolDemo2.utils.HttpUtils;
import org.junit.Test;

/**
 * Created by bjtangyunhao on 2017/4/26.
 */
public class TestHttp {

    @Test
    public void testGet(){
        String res = HttpUtils.sendGet("http://cs.sports.163.com/api/info/csl_api.json");
        System.out.println(res);
    }
}
