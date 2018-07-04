package com.bestcode.mr.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.retry.annotation.CircuitBreaker;

/**
 * @author xch
 * @create 2018-06-07 23:28
 **/

@EnableFeignClients(basePackages = "com.bestcode.product.client")
@EnableBinding({Sink.class, Source.class})
//@CircuitBreaker
//@SpringBootApplication
//@EnableEurekaClient
@SpringCloudApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
