package com.netease.tyh.springmvcRedisDemo.service;

import com.netease.tyh.springmvcRedisDemo.model.User;

import java.util.List;

/**
 * Created by bjtangyunhao on7/3/1.
 */
public interface UserService {
    User selectUserByName(String username);

    List<User> selectAllUsers();

    int updateUser(User user);
}
