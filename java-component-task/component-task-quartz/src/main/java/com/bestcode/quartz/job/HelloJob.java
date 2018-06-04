package com.bestcode.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.04
 */
public class HelloJob implements Job {

    private String scheduler;

    private static Logger logger = LoggerFactory.getLogger(Job.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
//        String scheduler = context.getJobDetail().getJobDataMap().getString("scheduler");
        logger.info("scheduler class: " + scheduler);
        logger.info("hello world --- " + new Date());
    }

    public void setScheduler(String scheduler) {
        this.scheduler = scheduler;
    }
}
