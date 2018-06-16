package com.bestcode.mr.order.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author xch
 * @create 2018-06-08 0:10
 **/
public class KeyUtil {

    /**
     * 生成主键
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
