package com.roytrack.netty.bio2_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by ruanchangming on 2016/03/18.
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket client= new Socket("127.0.0.1",9009);
        client.setSoTimeout(30000);
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        PrintStream out=new PrintStream(client.getOutputStream());
        BufferedReader result=new BufferedReader(new InputStreamReader(client.getInputStream()));
        while (true){
            System.out.println("plz input something");
            String arg=input.readLine();
            if(arg!=null&&arg.equals("bye"))return;
            out.println(arg);

            String echoContent=result.readLine();
            System.out.println("client： send command is '"+arg+"' return is '"+echoContent+"'");
        }
    }
}
