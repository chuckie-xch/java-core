package com.bestcode.javacore.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class SecondBatchWorker implements Runnable {

    private CountDownLatch latch;

    public SecondBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Second batch executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
