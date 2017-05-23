package com.netease.tyh.neteaseNosToolDemo.task;

import com.netease.tyh.neteaseNosToolDemo.util.Constant;
import com.netease.tyh.neteaseNosToolDemo.util.NosUtil;
import com.netease.tyh.neteaseNosToolDemo.vo.NosUrlConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by bjtangyunhao on 2017/4/12.
 */
public class TransOnlineImg {
    public static void main(String[] args) {
        TransOnlineImg transImg = new TransOnlineImg();
        transImg.transCslTeam();
    }

    private void transCslTeam(){
        String filePath = "C:\\Users\\bjtangyunhao\\Desktop\\cslFile\\ids\\acl_team_2017.csv";
        NosUrlConfig config = new NosUrlConfig();
        config.setBucketName(Constant.NOS_DEFAULT_BUCKET_NAME);
        config.setFrom(Constant.NOS_FROM);
        config.setDocid(NosUtil.getDocId(Constant.CORP_TYH));
        try {
            String encoding="utf-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String line;
                String imgUrl;
                while((line = bufferedReader.readLine()) != null){
                    //90
                    String img90 = line + ".jpg";
                    imgUrl = "http://cs.sports.163.com/images/team/90/" + img90;
                    config.setUrl(imgUrl);
                    config.setPath(Constant.CSL_FILE_PATH + Constant.TEAM_PATH + img90);
                    Map<String, String> resMap90 = NosUtil.uploadImageByUrl(config);
                    System.out.println(resMap90.get("ourl"));

                    //lk
//                    String imgLk = line + ".png";
//                    imgUrl = "http://cs.sports.163.com/images/team/lk/" + imgLk;
//                    config.setUrl(imgUrl);
//                    config.setPath(Constant.CSL_FILE_PATH + Constant.TEAM_PATH + "lk/" + imgLk);
//                    Map<String, String> resMapLk = NosUtil.uploadImageByUrl(config);
//                    System.out.println(resMapLk.get("ourl"));
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    private void transPlayer(){
        String filePath = "C:\\Users\\bjtangyunhao\\Desktop\\cslFile\\ids\\player_2017.csv";
        NosUrlConfig config = new NosUrlConfig();
        config.setBucketName(Constant.NOS_DEFAULT_BUCKET_NAME);
        config.setFrom(Constant.NOS_FROM);
        config.setDocid(NosUtil.getDocId(Constant.CORP_TYH));
        try {
            String encoding="utf-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String line;
                String imgUrl;
                while((line = bufferedReader.readLine()) != null){
                    String imgPath = line;
                    if(line.length() == 5){
                        imgPath = "0" + line;
                    }
                    //90
                    imgUrl = "http://picture.sodasoccer.com/photo_play/med/photo_play/030" + imgPath + ".jpg";
                    config.setUrl(imgUrl);
                    config.setPath(Constant.CSL_FILE_PATH + Constant.PLAYER_PATH + line + ".jpg");
                    Map<String, String> resMap = NosUtil.uploadImageByUrl(config);
                    System.out.println(resMap.get("ourl"));

                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
