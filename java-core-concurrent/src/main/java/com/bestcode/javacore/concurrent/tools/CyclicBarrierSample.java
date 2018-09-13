package com.bestcode.javacore.concurrent.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class CyclicBarrierSample {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action go Again");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicBarrierWorker(cyclicBarrier));
            t.start();
        }

    }
}
