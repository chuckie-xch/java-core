package com.bestcode.study.webflux.controller;

import com.bestcode.study.webflux.domain.User;
import com.bestcode.study.webflux.hander.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * test Controller
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.12.07
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserHandler userHandler;

    @GetMapping("/hello")
    public Mono<String> hello(final Model model) {
        model.addAttribute("name","张三丰");
        model.addAttribute("age",18);
        String path = "hello";
        return Mono.create(stringMonoSink -> stringMonoSink.success(path));
    }

    @GetMapping("/page/list")
    public String listPage(Model model) {
        Flux<User> users = userHandler.findAll();
        model.addAttribute("users",users);
        return "userList";
    }
}
