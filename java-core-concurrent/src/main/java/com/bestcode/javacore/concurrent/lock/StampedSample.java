package com.bestcode.javacore.concurrent.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.07
 */
public class StampedSample {

    private final StampedLock sl = new StampedLock();

    public void mutate(String data) {
        long stamp = sl.writeLock();
        try {
            System.out.println("write : "+ data);
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    public String access() {
        long stamp = sl.tryOptimisticRead();
        String data = "data";
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                data = "data1";
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return data;
    }
}
