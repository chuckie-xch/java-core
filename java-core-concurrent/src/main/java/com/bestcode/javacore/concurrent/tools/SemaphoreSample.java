package com.bestcode.javacore.concurrent.tools;

import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class SemaphoreSample {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
        System.out.println("Action go");
        semaphore.release(5);
        System.out.println("Wait for permits off");
        while (semaphore.availablePermits()!=0) {
            Thread.sleep(100L);
        }
        System.out.println("Action ... go again");
        semaphore.release(5);
    }
}
