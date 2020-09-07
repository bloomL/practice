package com.learn.quartz.about_quartz.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author liguo
 * @Description
 * @date 2020/9/7/007 17:00
 */
public class QuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // TODO 业务
        System.out.println("测试quartz  Job定时任务！！");
    }
}
