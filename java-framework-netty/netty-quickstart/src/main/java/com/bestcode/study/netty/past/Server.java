package com.bestcode.study.netty.past;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xch
 * @create 2018-08-01 22:06
 **/
public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口：" + port);
        } catch (IOException e) {
            System.out.println("服务端启动失败");
        }
    }

    public void start() {
        new Thread(new Runnable() {
            public void run() {
                doStart();
            }
        }).start();
    }

    public void doStart() {
        while (true) {
            try {
                Socket socket= serverSocket.accept();
                new ClientHandler(socket).start();
            } catch (IOException e) {
                System.out.println("服务端异常");
            }
        }
     }
}
