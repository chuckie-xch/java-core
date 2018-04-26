package com.bestcode.javacore.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.04.26
 */
public class FureTaskDemo {

    public static class CallerTask implements Callable<String> {

        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<String>(new CallerTask());
        // 启动线程
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println(result);
    }
}
