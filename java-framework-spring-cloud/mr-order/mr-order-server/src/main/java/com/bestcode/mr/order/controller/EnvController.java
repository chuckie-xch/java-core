package com.bestcode.mr.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-06-16 21:31
 **/
@RestController
@RequestMapping("/env")
public class EnvController {

    @Value("${env}")
    public String env;

    @GetMapping("/get")
    public String get(){
        return env;
    }
}
