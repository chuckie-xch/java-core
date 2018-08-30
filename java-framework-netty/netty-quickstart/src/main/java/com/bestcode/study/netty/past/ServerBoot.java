package com.bestcode.study.netty.past;

/**
 * @author xch
 * @create 2018-08-01 22:23
 **/
public class ServerBoot {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server  server = new Server(PORT);
        server.start();
    }
}
