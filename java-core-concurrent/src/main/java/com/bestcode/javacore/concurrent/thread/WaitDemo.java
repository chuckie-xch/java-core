package com.bestcode.javacore.concurrent.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.04.26
 */
public class WaitDemo {

    private static final int MAX_SIZE = 5;

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(MAX_SIZE);

    public class Producer implements Runnable{

        public void run() {
            produce();
        }

        public void produce() {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE ) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add("producer..");
                System.out.println("producer 生产 ------producer..");
                queue.notify();
            }

        }
    }

    public class Consumer implements Runnable{

        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String message = queue.take();
                System.out.println("consumer 取出 ------" + message);
                queue.notify();
            }
        }
    }

}
