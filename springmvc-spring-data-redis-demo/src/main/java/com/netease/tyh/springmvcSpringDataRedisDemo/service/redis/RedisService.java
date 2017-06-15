package com.netease.tyh.springmvcSpringDataRedisDemo.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * RedisService
 * Author: bjtangyunhao
 * Creation date: 2017年06月14日 17:48
 * Modified by: bjtangyunhao
 * Last modified: 2017年06月14日 17:48
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void put (String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    /* ------------------- sorted set ------------------- */
    public void zadd (String key, String value, double score){
        redisTemplate.opsForZSet().add(key, value, score);
    }

    public Set<String> zrevrange(String key, Long start, Long stop){
        return redisTemplate.opsForZSet().reverseRange(key, start, stop);
    }

}
