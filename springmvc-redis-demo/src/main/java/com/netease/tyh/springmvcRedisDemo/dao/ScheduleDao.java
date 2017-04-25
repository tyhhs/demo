package com.netease.tyh.springmvcRedisDemo.dao;

import com.netease.tyh.springmvcRedisDemo.model.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bjtangyunhao on 2017/3/13.
 */
public interface ScheduleDao {
    /**
     * 根据date获取球队未来五场比赛的数据
     * @param date "yyyy-MM-dd HH:mm:ss"
     * @param sid
     * @param cid
     * @param teamId
     * @return
     */
    List<Schedule> selectTeamScheduleAfterDate(@Param("sid") String sid, @Param("cid") int cid,
                                               @Param("teamId") Integer teamId, @Param("date") String date);
}
