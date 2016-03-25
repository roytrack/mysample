package com.roytrack.netty.netty3_2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by ruanchangming on 2016-3-25.
 */
public class TimeServer {
    private int port;
    public  void bind(int port){
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup =new NioEventLoopGroup();

        ServerBootstrap b=new ServerBootstrap();
        b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childHandler(new ChildChannelHandler());
        try {
            ChannelFuture f=b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
    public static void main(String[] args) {
        int port=9009;
        if(null!=args&args.length>1){
            port=Integer.valueOf(args[0]);
        }
        new TimeServer().bind(port);
    }
}
