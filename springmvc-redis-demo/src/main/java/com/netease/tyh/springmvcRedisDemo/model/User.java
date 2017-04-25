package com.netease.tyh.springmvcRedisDemo.model;

import java.io.Serializable;

/**
 * Created by bjtangyunhao on 2017/3/1.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String username; // 发布器用户名
    private String nickname; // 真实姓名
    private String role; //用户角色
    private String regDate; // 注册时间
    private String lastLoginDate; // 最后登录时间
    private int enabled; // 是否启用账号

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role='" + role + '\'' +
                ", regDate='" + regDate + '\'' +
                ", lastLoginDate='" + lastLoginDate + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
