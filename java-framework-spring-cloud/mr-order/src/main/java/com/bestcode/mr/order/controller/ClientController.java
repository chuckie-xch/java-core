package com.bestcode.mr.order.controller;

import java.util.Arrays;
import java.util.List;

import com.bestcode.mr.order.client.ProductClient;
import com.bestcode.mr.order.model.dto.CartDTO;
import com.bestcode.mr.order.model.entity.ProductInfo;
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
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

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
//        String response = restTemplate.getForObject("http://mr-product/msg", String.class);
        /**
         * 第四种方式，使用feignClient
         */
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("157875196366160022"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String decreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 2)));
        return "ok";
    }
}
