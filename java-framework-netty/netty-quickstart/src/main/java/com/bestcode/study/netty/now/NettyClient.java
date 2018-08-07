package com.bestcode.study.netty.now;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * netty客户端
 *
 * @author xch
 * @create 2018-08-07 20:45
 **/
public class NettyClient {

    static final String HOST = System.getProperty("host", "127.0.0.1");

    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) throws Exception {
        // 1.1 创建Reactor线程池，用来处理io请求，默认线程个数为内核cpu*2
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 1.2 创建启动类Bootstrap实例，用来设置客户端参数
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group) // 1.2.1 设置线程池
                    .channel(NioSocketChannel.class) // 1.2.2 指定用于创建客户端NIO通道的类
                    .option(ChannelOption.TCP_NODELAY, true)// 1.2.3 设置套接字参数
                    .handler(new ChannelInitializer<SocketChannel>() { // 1.2.4 设置自定义handler
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new NettyClientHandler());
                        }
                    });
            // 1.3 启动连接
            ChannelFuture future = bootstrap.connect(HOST, PORT).sync();
            // 1.4 同步等待连接断开
            future.channel().closeFuture().sync();
        } finally {
            // 1.5 优雅关闭线程池
            group.shutdownGracefully();
        }
    }

}
