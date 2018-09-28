 package com.bestcode.javacore.concurrent.cas;

import sun.misc.Contended;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.04.28
 */
public class AtomicDemo {

    private static AtomicLong atomicLong = new AtomicLong();

    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws InterruptedException {
        // 统计数组arrayOne中的0个个数
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                int size = arrayOne.length;
                for (int i = 0; i < size; i++) {
                    if (arrayOne[i].intValue() == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                int size = arrayTwo.length;
                for (int i = 0; i < size; i++) {
                    if (arrayTwo[i].intValue() == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("count 0:" + atomicLong.get());
    }
}
