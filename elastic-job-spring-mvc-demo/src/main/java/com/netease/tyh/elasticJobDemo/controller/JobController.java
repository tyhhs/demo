package com.netease.tyh.elasticJobDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * JobController
 * Author: bjtangyunhao
 * Creation date: 2017年05月19日 10:31
 * Modified by: bjtangyunhao
 * Last modified: 2017年05月19日 10:31
 */
@Controller
@RequestMapping("/job")
public class JobController {
    @RequestMapping("test")
    @ResponseBody
    private String test(){
        return "hello, elastic job";
    }
}
