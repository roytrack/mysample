package com.roytrack.netty.nio2_3_3;

/**
 * Created by roytrack on 2016/3/22.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port=9009;
        if(null!=args&args.length>1){
            port=Integer.valueOf(args[0]);
        }
        MultiplexerTimeServer timeServer=new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
