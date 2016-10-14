package com.roytrack.netty.bio2_1_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by roytrack on 2016/03/18.
 */
public class TimeServer {
    private static int port=8080;
    public static void main(String[] args) {
        if (args!=null&&args.length>0){
            try{
                port=Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        ServerSocket server=null;

        try {
            server=new ServerSocket(port);
            System.out.println("this server run port is "+port);
            Socket socket=null;
            while (true){
                socket=server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server!=null){
                System.out.println("This time server close ,port is "+port);
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
