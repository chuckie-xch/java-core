package com.bestcode.javacore.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class CountDownLatchSample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWoker(latch));
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread t= new Thread(new SecondBatchWorker(latch));
            t.start();
        }
        while (latch.getCount()!=1) {
            Thread.sleep(100L);
        }
        System.out.println("wait for first batch finish");
        latch.countDown();
    }
}
