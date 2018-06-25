package com.bestcode.mr.order.controller;

import com.bestcode.mr.order.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-06-22 22:41
 **/
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
public class SendMessageController {

    @Autowired
    private Source source;

    @GetMapping("/sendMessage")
    public void process() {
        String message = "sendMessage";
        OrderDTO  orderDto = new OrderDTO();
        orderDto.setBuyerName("张三丰");
        orderDto.setBuyerOpenid("openId");
        source.output().send(MessageBuilder.withPayload(orderDto).build());
    }
}
