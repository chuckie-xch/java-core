package com.bestcode.javacore.concurrent.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.08
 */
public class ThreadPoolDemo {

    @Test
    public void testCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println(index);
            });
        }
    }

    @Test
    public void testFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println(index);
            });
        }
    }


    @Test
    public void testScheduledThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println(index);
            });
        }
    }
}
