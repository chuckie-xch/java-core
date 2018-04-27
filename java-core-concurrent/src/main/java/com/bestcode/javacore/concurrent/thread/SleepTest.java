package com.bestcode.javacore.concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.04.27
 */
public class SleepTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("Thread A in sleep");
                    Thread.sleep(10000);
                    System.out.println("Thread A in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("Thread B in sleep");
                    Thread.sleep(10000);
                    System.out.println("Thread B in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        a.start();
        b.start();
    }
}
