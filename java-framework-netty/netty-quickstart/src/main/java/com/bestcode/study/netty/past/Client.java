package com.bestcode.study.netty.past;

import java.io.IOException;
import java.net.Socket;

/**
 * @author xch
 * @create 2018-08-01 22:05
 **/
public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;


    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(new Runnable() {
            public void run() {
                System.out.println("客户端启动成功");
                while (true) {
                    String messge = "hello world";
                    System.out.println("客户端发送数据：" + messge);
                    try {
                        socket.getOutputStream().write(messge.getBytes());
                    } catch (IOException e) {
                        System.out.println("写数据出错");
                    }
                    sleep();
                }
            }
        }).start();
    }

    public static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
