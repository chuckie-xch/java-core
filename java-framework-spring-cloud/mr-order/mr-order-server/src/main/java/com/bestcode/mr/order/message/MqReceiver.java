package com.bestcode.mr.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xch
 * @create 2018-06-22 21:59
 **/
@Slf4j
@Component
public class MqReceiver {


    /**
     * 1. @RabbitListener(queues = "myQueue")
     * 2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
     * 3. 自动创建队列并和exchange绑定
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver:{}", message);
    }

    /**
     * 数码供应商 服务接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            key = "computer",
            exchange = @Exchange("myOrder")
    ))
    public void processComputer(String message) {
        log.info("MqReceiver:{}", message);
    }

    /**
     * 水果供应商 服务接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            key = "fruit",
            exchange = @Exchange("myOrder")
    ))
    public void processFruit(String message) {
        log.info("MqReceiver:{}", message);
    }
}
