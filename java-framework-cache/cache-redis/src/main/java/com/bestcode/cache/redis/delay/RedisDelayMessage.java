package com.bestcode.cache.redis.delay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xch
 * @create 2018-08-02 23:48
 **/
@Component
public class RedisDelayMessage {

    @Autowired
    private RedisTemplate redisTemplate;

    public void product() {

    }


}
