package com.netease.tyh.springmvcRedisDemo.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Schedule")
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;


//    private String matchCode; // cid
//    private String matchType; // 没有数据
//    private int live;           // autoplay
//    private int round;          // matchDay
//    private int awayVote; // homevote
//    private String homeAbbr;    // home
//    private int homeVote;       // homevote
//    private String awayAbbr;    // away
//    private int homePenalty; // homeShootOut
//    private int awayPenalty; // awayShootOut

//    private String project; //gid

//    private String goals;     // 本场比赛进球详细信息
//    private String linkStat;  // 统计
//    private String linkLive;  // 直播
//    private String videoLink; // 视频直播
//    private String videoSet;  // 视频集锦

//    private String remark;    // 比赛备注
//    private int autoUpdateDate; // 锁定开球时间

    private String sid;// 赛季id
    private int gid;// 赛事id
    private int cid;// 联赛id
    private int mid;// 赛程id
    private String matchOfficialId;// 官方id
    private String competitionName; //联赛名称
    private int orderId;// 比赛序号
    private String date;// 比赛时间
    private String groupName;// 比赛分组代码
    private int matchDay;// 轮次
    private int roundNumber;// 杯赛第几轮
    private String roundType;// 杯赛轮次描述
    private int homeId;// 主队id
    private String homeGroup;// 主队组别
    private String home;// 主队名称
    private int homeScore;// 主队比分
    private int homevote;// 主队支持数
    private String homeCoach;// 主队教练
    private int awayId;// 客队id
    private String awayGroup;// 客队组别
    private String away;// 客队名称
    private int awayScore;// 客队比分
    private int awayvote;// 客队支持数
    private String awayCoach;// 客队教练
    private int venueId;// 球场id
    private String venue;// 球场名称
    private String city;// 比赛城市
    private int refereeId;// 裁判id
    private String referee;// 裁判名称
    private int status;// 比赛当前状态{1=未开赛,3=中场休息,4=比赛结束,5=延期,6=暂停,8=主场禁赛,9=取消,11=上半场,12=下半场,13=加时赛上半场,14=加时赛下半场,15=点球大战}
    private String period; //比赛状态
    //private int period;// 分节，上下半场等 ------ 2012欧洲杯新添加的属性，用于解析xml时进行bind
    private String additionaltime;// 比赛补时
    private String time;// 比赛进行分钟数
    private String tv;// 电视转播表
    private String linkNews;// 滚动新闻
    private String linkPreview;// 前瞻
    private String linkPhoto;// 滚动图片
    private String linkReport;// 战报
    private String linkStar;// 明星特写
    private String linkMatch;// 比赛专题链接
    private String linkStat; // 统计
    private String linkLive; // 直播
    private int autoLive;// 是否自动直播
    private int commentSize;// 直播到第几行
    private int flag;// 记录标识位
    private String postTime;// 提交修改时间
    private int roomId; // 直播室ID
    private String serialNumber;// 比赛编号
    private int homeShootOut;// 主队点球大战得分
    private int awayShootOut;// 客队点球大战得分
    // 直播页日历所有天数list结果集中字段
    private String calendarDate;
    private String dateCount;
    private String homeGoals;
    private String awayGoals;
    private String matchtime;
    private int matchstat;
    private int autoPlay;
    @JSONField(serialize = false)
    private String match_general; //比赛信息xml
    @JSONField(serialize = false)
    private String match_position; //比赛坐标xml


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getRoundType() {
        return roundType;
    }

    public void setRoundType(String roundType) {
        this.roundType = roundType;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public String getHomeGroup() {
        return homeGroup;
    }

    public void setHomeGroup(String homeGroup) {
        this.homeGroup = homeGroup;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public String getHomeCoach() {
        return homeCoach;
    }

    public void setHomeCoach(String homeCoach) {
        this.homeCoach = homeCoach;
    }

    public int getAwayId() {
        return awayId;
    }

    public void setAwayId(int awayId) {
        this.awayId = awayId;
    }

    public String getAwayGroup() {
        return awayGroup;
    }

    public void setAwayGroup(String awayGroup) {
        this.awayGroup = awayGroup;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getAwayCoach() {
        return awayCoach;
    }

    public void setAwayCoach(String awayCoach) {
        this.awayCoach = awayCoach;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(int refereeId) {
        this.refereeId = refereeId;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getLinkNews() {
        return linkNews;
    }

    public void setLinkNews(String linkNews) {
        this.linkNews = linkNews;
    }

    public String getLinkPreview() {
        return linkPreview;
    }

    public void setLinkPreview(String linkPreview) {
        this.linkPreview = linkPreview;
    }

    public String getLinkPhoto() {
        return linkPhoto;
    }

    public void setLinkPhoto(String linkPhoto) {
        this.linkPhoto = linkPhoto;
    }

    public String getLinkReport() {
        return linkReport;
    }

    public void setLinkReport(String linkReport) {
        this.linkReport = linkReport;
    }

    public String getLinkStar() {
        return linkStar;
    }

    public void setLinkStar(String linkStar) {
        this.linkStar = linkStar;
    }

    public String getLinkStat() {
        return linkStat;
    }

    public void setLinkStat(String linkStat) {
        this.linkStat = linkStat;
    }

    public String getLinkLive() {
        return linkLive;
    }

    public void setLinkLive(String linkLive) {
        this.linkLive = linkLive;
    }

    public String getLinkMatch() {
        return linkMatch;
    }

    public void setLinkMatch(String linkMatch) {
        this.linkMatch = linkMatch;
    }

    public int getAutoLive() {
        return autoLive;
    }

    public void setAutoLive(int autoLive) {
        this.autoLive = autoLive;
    }

    public int getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(int commentSize) {
        this.commentSize = commentSize;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getMatchOfficialId() {
        return matchOfficialId;
    }

    public void setMatchOfficialId(String matchOfficialId) {
        this.matchOfficialId = matchOfficialId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(String calendarDate) {
        this.calendarDate = calendarDate;
    }

    public String getDateCount() {
        return dateCount;
    }

    public void setDateCount(String dateCount) {
        this.dateCount = dateCount;
    }

    public int getHomevote() {
        return homevote;
    }

    public void setHomevote(int homevote) {
        this.homevote = homevote;
    }

    public int getAwayvote() {
        return awayvote;
    }

    public void setAwayvote(int awayvote) {
        this.awayvote = awayvote;
    }

    public String getAdditionaltime() {
        return additionaltime;
    }

    public void setAdditionaltime(String additionaltime) {
        this.additionaltime = additionaltime;
    }

    public int getHomeShootOut() {
        return homeShootOut;
    }

    public void setHomeShootOut(int homeShootOut) {
        this.homeShootOut = homeShootOut;
    }

    public int getAwayShootOut() {
        return awayShootOut;
    }

    public void setAwayShootOut(int awayShootOut) {
        this.awayShootOut = awayShootOut;
    }


    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(String matchtime) {
        this.matchtime = matchtime;
    }

    public int getMatchstat() {
        return matchstat;
    }

    public void setMatchstat(int matchstat) {
        this.matchstat = matchstat;
    }

    public int getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(int autoPlay) {
        this.autoPlay = autoPlay;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getMatch_general() {
        return match_general;
    }

    public void setMatch_general(String match_general) {
        this.match_general = match_general;
    }

    public String getMatch_position() {
        return match_position;
    }

    public void setMatch_position(String match_position) {
        this.match_position = match_position;
    }

}
