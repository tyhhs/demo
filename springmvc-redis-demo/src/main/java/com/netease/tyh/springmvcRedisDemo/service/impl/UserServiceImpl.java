package com.netease.tyh.springmvcRedisDemo.service.impl;

import com.netease.tyh.springmvcRedisDemo.dao.UserDao;
import com.netease.tyh.springmvcRedisDemo.model.User;
import com.netease.tyh.springmvcRedisDemo.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bjtangyunhao on 2017/3/1.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    @Cacheable(value = "userCache",key = "'selectUserByName_' + #username ")
    public User selectUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    @Override
    @Cacheable(value = "userCache",key = "'selectAllUsers'")
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    @CacheEvict(value = "userCache",allEntries=true)
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
