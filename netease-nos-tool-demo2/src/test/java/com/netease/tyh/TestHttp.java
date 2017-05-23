package com.netease.tyh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netease.tyh.neteaseNosToolDemo2.nos.NosConfig;
import com.netease.tyh.neteaseNosToolDemo2.nos.NosTools;
import com.netease.tyh.neteaseNosToolDemo2.utils.HttpUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bjtangyunhao on 2017/4/26.
 */
public class TestHttp {

    @Test
    public void testGet(){
        String res = HttpUtils.sendGet("http://cs.sports.163.com/api/info/csl_api.json");
        System.out.println(res);
    }

    @Test
    public void testNosPostImg(){
        NosConfig.Builder nosBuilder = NosConfig.custom();
        //参数
        nosBuilder.setUploadtype("cms")
                .setImageId("test image")
                .setPath("football/ifb/player/test1.jpg");
        //图片
        File file = new File("C:\\Users\\bjtangyunhao\\Desktop\\234.jpg");
        nosBuilder.setFile(file);

        String res = NosTools.uploadImg(nosBuilder.build());
        System.out.println(res);
    }

    @Test
    public void testNosPostOnlineImg(){
        NosConfig.Builder nosBuilder = NosConfig.custom();
        nosBuilder.setUrl("http://goal.sports.163.com/playerlogo/499317.jpg");
        //参数
        nosBuilder.setPath("sports/football/ifb/player/499317.jpg")
                .setDocid("bjtangyunhao");

        String res = NosTools.uploadUrlImg(nosBuilder.build());
        System.out.println(res);
    }

    @Test
    public void transNbaPlayerOnlineImage(){
        File file = new File("C:\\Users\\bjtangyunhao\\Desktop\\NBA data\\list\\player.csv");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                NosConfig.Builder nosBuilder = NosConfig.custom();
                nosBuilder.setUrl("http://nba.sports.163.com/2016/images/player/small/"+line+".jpg");
                //参数
                nosBuilder.setPath("sports/basketball/nba/player/" + line + ".jpg")
                        .setDocid("bjtangyunhao");

                String res = NosTools.uploadUrlImg(nosBuilder.build());
                JSONObject json = JSON.parseObject(res);
                System.out.println(json.get("ourl"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void transNbaTeamOnlineImage(){
        File file = new File("C:\\Users\\bjtangyunhao\\Desktop\\NBA data\\list\\team.csv");
        List<String> types = Arrays.asList("logo", "banner", "mobile", "hbg", "sbg");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                System.out.println("---------trans team:" + line + "--------------");
                for(String type : types){
                    NosConfig.Builder nosBuilder = NosConfig.custom();
                    String filename = "";
                    if(type.equals("mobile")){
                        filename = line + ".png";
                    }
                    else {
                        filename = "team" + line + ".gif";
                    }
                    String rawType = type;
                    if(type.equals("logo")){
                        rawType = "90";
                    }
                    nosBuilder.setUrl("http://nba.sports.163.com/2016/images/team/"+rawType+"/"+filename);
                    //参数
                    nosBuilder.setPath("sports/basketball/nba/team/"+type+"/"+line+".jpg")
                            .setDocid("bjtangyunhao");

                    String res = NosTools.uploadUrlImg(nosBuilder.build());
                    JSONObject json = JSON.parseObject(res);
                    System.out.println(json.get("ourl"));
                }
                System.out.println("---------trans team:" + line + "--------------end");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}