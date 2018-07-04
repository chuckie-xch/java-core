package com.bestcode.mr.order.controller;

import java.util.Arrays;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xch
 * @create 2018-07-04 21:02
 **/
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {


//    @HystrixCommand(fallbackMethod = "fallback")
    /**
     * 超时配置
     *
     * @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
     * value = "3000")})
     */
    /**
     * 断路配置
     * @HystrixCommand(commandProperties = {
     * @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 设置熔断
     * @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
     * @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
     * @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
     * })
     *
     */
    @HystrixCommand(commandKey = "findProductInfoList")
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8080/product/listForOrder", Arrays.asList
                        ("157875196366160022"),
                String.class);
    }

    private String fallback() {
        return "太拥挤了，请稍后再试~~";
    }

    private String defaultFallback() {
        return "默认降级提示：服务繁忙，稍后重试~~";
    }
}
