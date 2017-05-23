package com.netease.tyh.elasticJobDemo.job;

import com.dangdang.ddframe.job.api.AbstractPerpetualElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * MyPerpetualElasticJob
 * Author: bjtangyunhao
 * Creation date: 2017年05月18日 10:51
 * Modified by: bjtangyunhao
 * Last modified: 2017年05月18日 10:51
 */
public class MyPerpetualElasticJob extends AbstractPerpetualElasticJob<Integer> {

    //fetchData方法的返回值只有为null或长度为空时，作业才会停止执行，否则作业会一直运行下去
    @Override
    protected List<Integer> fetchData(JobExecutionMultipleShardingContext context) {
        List<Integer> result = Lists.newArrayList(Arrays.asList(1, 2, 3));
        System.out.println(Joiner.on(":").join("execute MyPerpetualElasticJob", "fetchData"));
        return result;
    }

    @Override
    protected boolean processData(JobExecutionMultipleShardingContext context, Integer data) {
        System.out.println(Joiner.on(":").join("execute MyPerpetualElasticJob", "processData", data));
        return true;
    }
}
