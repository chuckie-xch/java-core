package com.bestcode.task.spring.quartz.config;

import com.bestcode.task.spring.quartz.job.HelloJob;
import com.bestcode.task.spring.quartz.task.HelloTask;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * quartz的配置
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.06
 */
@Configuration
public class JobConfig {

    @Bean("jobDetail")
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(HelloTask task) {
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setConcurrent(false);
        factoryBean.setTargetObject(task);
        factoryBean.setTargetMethod("sayHello");
        return factoryBean;
    }

    @Bean("cronJobTrigger")
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail.getObject());
        cronTriggerFactoryBean.setCronExpression("*/10 * * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronJobTrigger) {

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setStartupDelay(1);
        // 用于集群，启动时更新已存在的job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setTriggers(cronJobTrigger);
        return schedulerFactoryBean;
    }

}
