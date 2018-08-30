package com.bestcode.javacore.concurrent.queue;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.concurrent.DelayQueue;

import sun.util.calendar.CalendarUtils;

/**
 * @author xch
 * @create 2018-08-02 22:02
 **/
public class DelayQueueDemo {

    public static void main(String[] args) {
        // 创建队列存储订单任务
        DelayQueue<MyDelayed> delayQueue = new DelayQueue<MyDelayed>();
        // 生产者产生多个延迟10s的延迟任务
        new Thread(new ProducerDelay(delayQueue, 10)).start();
        // 开启消费者轮询
        new Thread(new ConsumerDelay(delayQueue)).start();
    }


    static class ProducerDelay implements Runnable {

        DelayQueue<MyDelayed> delayQueue;
        int delaySecond;

        public ProducerDelay(DelayQueue<MyDelayed> delayQueue, int delaySecond) {
            this.delayQueue = delayQueue;
            this.delaySecond = delaySecond;
        }

        @Override
        public void run() {
            String orderId = "1010101";
            for (int i = 0; i < 10; i++) {
                MyDelayed delayed = new MyDelayed(this.delaySecond, orderId + i);
                // 向队列中插入一个元素
                delayQueue.add(delayed);
                System.out.println(LocalDateTime.now() + " Thread:" + Thread.currentThread() + "添加了一个delay,orderId = " +
                        "" + delayed.getOrderId());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class ConsumerDelay implements Runnable {

        DelayQueue<MyDelayed> delayQueue;

        public ConsumerDelay(DelayQueue<MyDelayed> delayQueue) {
            this.delayQueue = delayQueue;
        }

        @Override
        public void run() {
            while (true) {
                MyDelayed delayed = null;
                try {
                    delayed = delayQueue.take();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 如果存在，则任务达到超时时间
                if (delayed != null) {
                    System.out.println(LocalDateTime.now() + " Thread:" + Thread.currentThread() + "消费了一个delay," +
                            "orderId=" + delayed.getOrderId());
                } else {
                    System.out.println("任务扫描中....");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
