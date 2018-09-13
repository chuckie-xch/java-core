package com.bestcode.javacore.concurrent.tools;

import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class SemaphoreWorker implements Runnable {

    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("execute");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
