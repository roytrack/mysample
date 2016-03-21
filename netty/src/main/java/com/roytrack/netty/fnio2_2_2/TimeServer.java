package com.roytrack.netty.fnio2_2_2;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by ruanchangming on 2016/03/21.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port=9009;
        if(args!=null&&args.length>0){
            try{
                port=Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        ServerSocket server=null;
        try{
            server=new ServerSocket(port);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
