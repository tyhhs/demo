package com.netease.tyh.elasticJobLiteDemo.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MyElasticJob
 * Author: bjtangyunhao
 * Creation date: 2017年05月19日 18:18
 * Modified by: bjtangyunhao
 * Last modified: 2017年05月19日 18:18
 */
public class MyElasticJob  implements SimpleJob {

    private final Logger log  = LoggerFactory.getLogger(this.getClass());

    public void execute(ShardingContext context) {
        log.info(Joiner.on("").join(context.getJobName(),"执行分片：",
                context.getShardingItem(), ",", context.getShardingParameter()));
    }
}
