package com.bestcode.mr.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xch
 * @create 2018-06-08 23:21
 **/
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 第一种方式，url hard code
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://127.0.0.1:8080/msg", String.class);
        /**
         * 第二种方式，使用LoadBalancerClient,动态获取host,port
         */
//        ServiceInstance serviceInstance = loadBalancerClient.choose("mr-product");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);
        /**
         * 第三种方式，见RestTemplateConfig
         */
        String response = restTemplate.getForObject("http://mr-product/msg", String.class);
        log.info("response={}", response);
        return response;
    }
}
