package com.bestcode.javacore.concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class CyclicBarrierWorker implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierWorker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("executed!");
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
