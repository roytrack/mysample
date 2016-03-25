package com.roytrack.netty.aio2_4_1;

/**
 * Created by ruanchangming on 2016-3-25.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port=9009;
        if(args!=null&&args.length>1){
            port=Integer.valueOf(args[0] );
        }
        AsyncTimeServerHandler timeServer=new AsyncTimeServerHandler(port);
        new Thread(timeServer,"AIO-AsyncTimeServerHandler-001").start();
    }
}
