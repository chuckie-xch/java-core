package com.bestcode.product.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-06-08 23:20
 **/
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product 'msg'";
    }
}
