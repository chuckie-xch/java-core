package com.bestcode.mr.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author xch
 * @create 2018-06-22 22:39
 **/
@Component
@Slf4j
public class StreamReceiver {

    @StreamListener(Sink.INPUT)
    public void process(String message){
        log.info("StreamReceiver: {}",message);
    }
}
