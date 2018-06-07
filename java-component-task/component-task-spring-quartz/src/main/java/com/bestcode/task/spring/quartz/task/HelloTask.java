package com.bestcode.task.spring.quartz.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.06
 */
@Component
public class HelloTask {

    public void sayHello() {
        System.out.println("Hello quartz");
    }
}
