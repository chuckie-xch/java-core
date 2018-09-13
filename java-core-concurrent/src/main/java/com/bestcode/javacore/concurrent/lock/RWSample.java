package com.bestcode.javacore.concurrent.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.07
 */
public class RWSample {

    private final Map<String,String> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();


    public String get(String key) {
        r.lock();
        System.out.println("读锁锁定！");
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    public String put(String key, String value) {
        w.lock();
        System.out.println("写锁锁定");
        try {
            return m.put(key,value);
        } finally {
            w.unlock();
        }
    }
}
