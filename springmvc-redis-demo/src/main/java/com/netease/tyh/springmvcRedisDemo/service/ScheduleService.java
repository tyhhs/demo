package com.netease.tyh.springmvcRedisDemo.service;

import com.netease.tyh.springmvcRedisDemo.model.Schedule;

import java.util.List;

/**
 * Created by bjtangyunhao on 2017/3/13.
 */
public interface ScheduleService {
    List<Schedule> selectTeamScheduleAfterDate(String sid, int cid, Integer teamId, String date);

    void flushScheduleCache();
}
