package com.bestcode.javacore.concurrent;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.04.28
 */
public class ThreadLocalDemo {

    static ThreadLocal<String> localVariable = new ThreadLocal<String>();

    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
        // 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                localVariable.set("threadOne local var");
                print("threadOne");
                System.out.println("threadOne remove after:" + localVariable.get());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                localVariable.set("threadTwo loacl var");
                print("threadTwo");
                System.out.println("threadTwo remove after:" + localVariable.get());
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
