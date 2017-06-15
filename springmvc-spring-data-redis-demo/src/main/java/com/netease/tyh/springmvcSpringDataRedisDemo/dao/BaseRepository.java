package com.netease.tyh.springmvcSpringDataRedisDemo.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * BaseRepository
 * Author: bjtangyunhao
 * Creation date: 2017年06月15日 15:36
 * Modified by: bjtangyunhao
 * Last modified: 2017年06月15日 15:36
 */
public interface BaseRepository<T> extends CrudRepository<T, String> {
}
