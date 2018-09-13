package com.bestcode.javacore.concurrent.thread;

/**
 * 死锁demo
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.12
 */
public class DeadLockSample extends Thread {

    private String first;
    private String second;

    public DeadLockSample(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + "获取锁：" + first);
            try {
                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + "获取锁：" + second);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockA =  "lockA";
        String lockB = "lockB";
        DeadLockSample t1 = new DeadLockSample("Thread1",lockA,lockB);
        DeadLockSample t2 = new DeadLockSample("Thread2",lockB,lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
