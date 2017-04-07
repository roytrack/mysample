package com.roytrack.netty.udp12_1;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * Created by roytrack on 2017-04-07.
 */
public class ChineseProverbClient {

    public void run(int port) throws InterruptedException {
        EventLoopGroup client=new NioEventLoopGroup();
        try{
            Bootstrap b=new Bootstrap();
            b.group(client)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProverbClientHandler());
            Channel channel=b.bind(0).sync().channel();
            channel.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语", CharsetUtil.UTF_8)
                    ,new InetSocketAddress("255.255.255.255",8080))).sync();
            if(!channel.closeFuture().await(15000)){
                System.out.println("消息查询超时！");
            }
        }finally {
            client.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChineseProverbClient c=new ChineseProverbClient();
        c.run(8080);
    }
}
