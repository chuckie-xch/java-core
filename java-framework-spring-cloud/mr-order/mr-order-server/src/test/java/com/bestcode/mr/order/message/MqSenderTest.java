package com.bestcode.mr.order.message;

import static org.junit.Assert.*;

import java.util.Date;

import com.bestcode.mr.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSendMessage() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    @Test
    public void testSendOrder() {
        amqpTemplate.convertAndSend("myOrder", "computer", "now " + new Date());
    }

}