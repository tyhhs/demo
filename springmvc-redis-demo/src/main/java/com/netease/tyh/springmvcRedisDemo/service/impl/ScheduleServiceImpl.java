package com.netease.tyh.springmvcRedisDemo.service.impl;

import com.netease.tyh.springmvcRedisDemo.dao.ScheduleDao;
import com.netease.tyh.springmvcRedisDemo.model.Schedule;
import com.netease.tyh.springmvcRedisDemo.service.ScheduleService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bjtangyunhao on 2017/3/13.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    ScheduleDao scheduleDao;

    @Override
    @Cacheable(value = "scheduleCache#300",
            key = "'selectTeamScheduleAfterDate_' + #sid + '_'+ #cid + '_'+ #teamId + '_'+ #date")
    public List<Schedule> selectTeamScheduleAfterDate(String sid, int cid, Integer teamId, String date) {
        return scheduleDao.selectTeamScheduleAfterDate(sid, cid, teamId, date);
    }

    @Override
    @CacheEvict(value = "scheduleCache", allEntries=true)
    public void flushScheduleCache() {
    }
}
