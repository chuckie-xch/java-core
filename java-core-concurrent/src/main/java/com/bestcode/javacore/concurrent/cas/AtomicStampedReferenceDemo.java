package com.bestcode.javacore.concurrent.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.28
 */
public class AtomicStampedReferenceDemo {

    private AtomicStampedReference<String> asr = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) {

    }

    class Worker implements Runnable {

        @Override
        public void run() {
            asr.weakCompareAndSet("A", "B", 20, 30);
        }
    }
}
