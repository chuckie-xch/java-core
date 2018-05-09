package com.bestcode.consumer;

import com.bestcode.api.entity.User;
import com.bestcode.api.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.08
 */
public class Consumer {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.findByName("张三丰");
        System.out.println(user);
        System.in.read();
    }
}
