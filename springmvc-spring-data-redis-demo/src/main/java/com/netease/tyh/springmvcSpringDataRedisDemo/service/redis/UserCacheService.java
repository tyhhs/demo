package com.netease.tyh.springmvcSpringDataRedisDemo.service.redis;

import com.netease.tyh.springmvcSpringDataRedisDemo.model.User;
import com.netease.tyh.springmvcSpringDataRedisDemo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * UserCacheService
 * Author: bjtangyunhao
 * Creation date: 2017年06月15日 14:15
 * Modified by: bjtangyunhao
 * Last modified: 2017年06月15日 14:15
 */
@Service
public class UserCacheService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    UserRepository userRepository;

    public void cacheUser(User user){
        userRepository.save(user);
    }

    public User getUser(String id){
        return userRepository.findOne(id);
    }
}
