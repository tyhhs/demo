package com.netease.tyh.springmvcRedisDemo.dao;

import com.netease.tyh.springmvcRedisDemo.model.User;

import java.util.List;

/**
 * Created by bjtangyunhao on 2017/3/1.
 */
public interface UserDao {
    User selectUserByName(String name);

    List<User> selectAllUsers();

    int updateUser(User user);
}