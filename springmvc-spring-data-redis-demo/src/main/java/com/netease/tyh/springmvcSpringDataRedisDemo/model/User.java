package com.netease.tyh.springmvcSpringDataRedisDemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * User
 * Author: bjtangyunhao
 * Creation date: 2017年06月15日 14:10
 * Modified by: bjtangyunhao
 * Last modified: 2017年06月15日 14:10
 */
@RedisHash("user")
public class User implements Serializable {
    @Id
    private  Long userId;
    private String name;
    private Integer age;
    private Address address;

    public User(Long userId, String name, Integer age, Address address) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
