package com.netease.tyh.elasticJobLiteDemo.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.google.common.base.Joiner;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MyElasticJob
 * Author: bjtangyunhao
 * Creation date: 2017年05月19日 18:18
 * Modified by: bjtangyunhao
 * Last modified: 2017年05月19日 18:18
 */
public class MyElasticJob  implements SimpleJob {

    private final Logger log  = Logger.getLogger(this.getClass());

    public void execute(ShardingContext context) {
        log.info("sharding job started");
        System.out.println("sharding job started");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        switch (context.getShardingItem()) {
            case 0:
                log.info(Joiner.on(":").join(0, format.format(new Date())));
                break;
            case 1:
                log.info(Joiner.on(":").join(1, format.format(new Date())));
                break;
            case 2:
                log.info(Joiner.on(":").join(2, format.format(new Date())));
                break;
            default:
                log.info(Joiner.on(":").join("default", format.format(new Date())));
        }
    }
}
