package com.bestcode.spring.controller;

import com.bestcode.spring.context.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.23
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/application")
    public String test() {
        ApplicationContext providerContext = ApplicationContextProvider.getApplicationContext();
        if (providerContext == applicationContext) {
            System.out.println("both context are same");
        } else {
            System.out.println("context are different");
        }
        return "test";
    }
}
