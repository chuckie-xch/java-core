package com.bestcode.study.netty.now;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author xch
 * @create 2018-08-07 21:38
 **/
public class NettyServer {

    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) throws Exception {
        // 1.1 创建主从Reactor线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 1.2 创建启动类ServerBootstrap实例，设置相关参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 1.2.1 设置主从线程池组
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 1.2.2 设置用于创建指定客户端通道的NIO类
                    .option(ChannelOption.SO_BACKLOG, 100) // 1.2.3 设置客户端套接字参数
                    .handler(new LoggingHandler(LogLevel.INFO)) // 1.2.4 设置日志handler
                    .childHandler(new ChannelInitializer<SocketChannel>() {// 1.2.5 设置用户自定义的handler
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new NettyServerHandler());
                        }
                    });
            // 1.3 启动服务器
            ChannelFuture future = bootstrap.bind(PORT).sync();
            System.out.println("server started");
            // 1.4 同步等待服务socket关闭
            future.channel().closeFuture().sync();
        } finally {
            // 优雅关闭线程池
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
