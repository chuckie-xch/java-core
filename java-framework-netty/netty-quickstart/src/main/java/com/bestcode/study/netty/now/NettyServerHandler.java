package com.bestcode.study.netty.now;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author xch
 * @create 2018-08-07 21:46
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf message = (ByteBuf) msg;
        byte[] response = new byte[message.readableBytes()];
        message.readBytes(response);
        System.out.println(atomicInteger.incrementAndGet() + ":receive client info;" + new String(response));

        String sendContent = "hello client, i am Server";
        ByteBuf sendMsg = Unpooled.buffer(sendContent.length());
        sendMsg.writeBytes(sendContent.getBytes());
        ctx.writeAndFlush(sendMsg);
        System.out.println("send info to cient:" + sendContent);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("accepted client");
        ctx.fireChannelActive();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
