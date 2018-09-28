package com.bestcode.javacore.concurrent.cas.source;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.28
 */
public class MyAtomicIntegerTest {

    private static MyAtomicInteger myAtomicInteger = new MyAtomicInteger();

    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayOne.length; i++) {
                    if (arrayOne[i] == 0) {
                        myAtomicInteger.incrementAndGet();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayTwo.length; i++) {
                    if (arrayTwo[i] == 0) {
                        myAtomicInteger.incrementAndGet();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("total 0 : " + myAtomicInteger.get());
    }
}
