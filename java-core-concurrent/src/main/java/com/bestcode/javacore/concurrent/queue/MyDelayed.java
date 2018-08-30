package com.bestcode.javacore.concurrent.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author xch
 * @create 2018-08-02 22:00
 **/
public class MyDelayed implements Delayed {

    /**
     * 任务超时时间戳
     */
    private long expire = 0;
    private String orderId;

    public MyDelayed(int delaySecond, String orderId) {
        // 任务超时时间戳 = 当前时间 + 延迟时间
        expire = System.currentTimeMillis() / 1000 + delaySecond;
        this.orderId = orderId;
    }

    /**
     * 获取延迟时间（过期时间-当前时间）
     * 还有多长时间超时
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return expire - System.currentTimeMillis() / 1000;
    }

    /**
     * 用于延迟队列内部比较排序
     * 当前延迟时间-其他对象延迟时间
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return d == 0 ? 0 : (d < 0 ? -1 : 1);
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
