package com.bestcode.study.webflux.controller;

import com.bestcode.study.webflux.domain.User;
import com.bestcode.study.webflux.hander.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User Controller
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.12.07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserHandler userHandler;

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userHandler.save(user);
    }

    @PutMapping
    public Mono<User> update(@RequestBody User user) {
        return userHandler.update(user);
    }

    @DeleteMapping
    public Mono<Long> delete(@PathVariable("id") Long id) {
        return userHandler.delete(id);
    }

    @GetMapping
    public Flux<User> findAll() {
        return userHandler.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> findUserById(@PathVariable("id") Long id){
        return userHandler.findUserById(id);
    }
}
