package com.bestcode.spring.controller;

import com.bestcode.spring.entity.User;
import com.bestcode.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-05-22 20:54
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setAge(23);
        user.setName("张无忌");
        userService.printMsg("test userService");
        return user;
    }
}
