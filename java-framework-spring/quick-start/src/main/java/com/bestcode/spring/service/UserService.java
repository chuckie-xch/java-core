package com.bestcode.spring.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.25
 */
@Service
@Scope("prototype")
public class UserService {

    private String token;

    public void printMsg(String msg) {
        System.out.println("token:" + token);
        System.out.println(msg);
    }

    public void setToken(String token) {
        this.token = token;
    }
}
