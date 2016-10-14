package com.roytrack.netty.aio2_4_1;

/**
 * Created by roytrack on 2016-3-25.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port=9009;
        if(args!=null&&args.length>1){
            port=Integer.valueOf(args[0]);
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port)).start();
    }
}
