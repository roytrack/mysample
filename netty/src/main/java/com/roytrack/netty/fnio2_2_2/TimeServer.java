package com.roytrack.netty.fnio2_2_2;

import com.roytrack.netty.bio2_1_2.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            TimeServerHandlerExecutePool executePool=new TimeServerHandlerExecutePool(50,10000);
            Socket s=null;
            while (true){
                s=server.accept();
                executePool.execute(new TimeServerHandler(s));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server!=null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server=null;
            }
        }
    }
}
