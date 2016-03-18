package com.roytrack.netty.bio2_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by ruanchangming on 2016/03/18.
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        BufferedReader reader=null;
        PrintWriter writer=null;

        try{
            reader=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer=new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime=null;
            String command=null;
            while (true){
                command=reader.readLine();
                System.out.println("handler receive command "+command);
                if(command==null)break;
                currentTime="time".equals(command)?new Date(System.currentTimeMillis()).toString():"BAD COMMAND";
                writer.println(currentTime);
                System.out.println("handler send result " + currentTime);
            }

        }catch (Exception e){
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(writer!=null){
                writer.close();
                writer=null;
            }
            try{
                this.socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            this.socket=null;

        }



    }
}
