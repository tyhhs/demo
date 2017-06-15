package com.netease.tyh.springmvcSpringDataRedisDemo.model;

import java.io.Serializable;

/**
 * Address
 * Author: bjtangyunhao
 * Creation date: 2017年06月15日 14:10
 * Modified by: bjtangyunhao
 * Last modified: 2017年06月15日 14:10
 */
public class Address implements Serializable{

    private String province;
    private String city;
    private String district;

    public Address(String province, String city, String district) {
        this.province = province;
        this.city = city;
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
