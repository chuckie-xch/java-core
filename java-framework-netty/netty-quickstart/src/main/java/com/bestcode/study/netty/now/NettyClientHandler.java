package com.bestcode.study.netty.now;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author xch
 * @create 2018-08-07 21:16
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private final byte[] request;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public NettyClientHandler() {
        request = "hello server, i am client".getBytes();
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client already connected");
        ByteBuf message = null;
        for (int i = 0; i < 1; i++) {
            message = Unpooled.buffer(request.length);
            message.writeBytes(request);
            ctx.writeAndFlush(message);
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf message = (ByteBuf) msg;
        byte[] response = new byte[message.readableBytes()];
        message.readBytes(response);
        System.out.println(atomicInteger.incrementAndGet() + ":receive from server: " + new String(response));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
