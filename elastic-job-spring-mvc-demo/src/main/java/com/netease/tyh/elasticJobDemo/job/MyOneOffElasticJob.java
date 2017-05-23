package com.netease.tyh.elasticJobDemo.job;

import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.google.common.base.Joiner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MyOneOffElasticJob
 * Author: bjtangyunhao
 * Creation date: 2017年05月18日 10:48
 * Modified by: bjtangyunhao
 * Last modified: 2017年05月18日 10:48
 */
@Component
public class MyOneOffElasticJob extends AbstractOneOffElasticJob{
    @Override
    protected void process(JobExecutionMultipleShardingContext jobExecutionMultipleShardingContext) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        System.out.println(Joiner.on(":").join("execute MyOneOffElasticJob", sdf.format(date)));
    }
}
