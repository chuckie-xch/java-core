package com.bestcode.javacore.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xch
 * @create 2018-08-06 21:18
 **/
public class NioServer {

    // 1. 创建缓冲区
    private ByteBuffer sendbuffer = ByteBuffer.allocate(1024);
    private ByteBuffer receivebuffer = ByteBuffer.allocate(1024);

    private Selector selector;

    public NioServer(int port) throws IOException {
        // 2. 获取一个服务器套接字通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 3. 设置socket为非阻塞式
        serverSocketChannel.configureBlocking(false);
        // 4. 获取与该通道关联的服务端套接字
        ServerSocket serverSocket = serverSocketChannel.socket();
        // 5. 绑定服务端地址
        serverSocket.bind(new InetSocketAddress(port));
        // 6. 获取一个选择器
        selector = Selector.open();
        // 7. 注册通道到选择器，选择对OP_ACCEPT事件感兴趣
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server Started");
        // 8. 处理事件
        int num = 0;
        while (true) {
            // 8.1 获取就绪事件结合
            int selectKeyCount = selector.select();
            System.out.println(num++ + "selectCount:" + selectKeyCount);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 8.2 处理就绪事件
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                processSelectedKey(selectionKey);
            }
        }

    }

    private void processSelectedKey(SelectionKey selectionKey) throws IOException {
        SocketChannel client = null;
        // 8.2.1 客户端完成与服务端三次握手
        if (selectionKey.isAcceptable()) {
            // 8.2.1.1获取完成握手的套接字
            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
            client = server.accept();
            if (client == null) {
                return;
            }
            System.out.println("accepted client");
            // 8.2.1.2 该套接字为非阻塞模式
            client.configureBlocking(false);
            // 8.2.1.3 注册该套接字到选择器，对OP_READ事件感兴趣
            client.register(selector, SelectionKey.OP_READ);
            // 8.2.2 读取事件
        } else if (selectionKey.isReadable()) {
            // 8.2.2.1 读取数据
            client = (SocketChannel) selectionKey.channel();
            receivebuffer.clear();
            int count = client.read(receivebuffer);
            if (count > 0) {
                String receiveContent = new String(receivebuffer.array(), 0, count);
                System.out.println("receive client info: " + receiveContent);
            }
            // 8.2.2.2 发送数据到client
            sendbuffer.clear();
            client = (SocketChannel) selectionKey.channel();
            String sendContent = "hello client, I am server";
            sendbuffer.put(sendContent.getBytes());
            sendbuffer.flip();
            client.write(sendbuffer);
            System.out.println("send info to client" + sendContent);
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 7001;
        NioServer server = new NioServer(port);
    }
}
