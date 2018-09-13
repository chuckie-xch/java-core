package com.bestcode.javacore.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class FirstBatchWoker implements Runnable {

    private CountDownLatch latch;

    public FirstBatchWoker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("first batch executed!");
        latch.countDown();
    }
}
