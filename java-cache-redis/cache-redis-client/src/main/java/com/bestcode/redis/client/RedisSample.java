package com.bestcode.redis.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.13
 */
public class RedisSample {

    private Jedis jedis;

    @Before
    public void connect() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    @After
    public void close() {
        jedis.close();
    }

    @Test
    public void testString() {
//        jedis.set("hello", "world");
//        System.out.println("hello:" + jedis.get("hello"));
        jedis.incr("count");
        System.out.println("count:" + jedis.get("count"));

    }

    @Test
    public void testhash() {
        jedis.hset("zhangsanfeng", "age", "24");
        jedis.hset("zhangsanfeng", "name", "aaa");
        System.out.println(jedis.hgetAll("zhangsanfeng"));
    }

    @Test
    public void testList() {
        jedis.rpush("c-list", "1");
        jedis.rpush("c-list", "2");
        jedis.rpush("c-list", "3");
        System.out.println(jedis.lrange("c-list", 0, -1));
    }
}
