package com.bestcode.task.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.02
 */
@Configuration
public class TaskConfiguration {

    @Scheduled(cron = "0/20 * * * * ?")
    public void scheduler() {
        System.out.println("task start");
    }
}

