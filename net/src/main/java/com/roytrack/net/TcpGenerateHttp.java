package com.roytrack.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author roytrack
 * @time 2018/8/1 下午3:37
 * 
 */
public class TcpGenerateHttp {

    public static void main(String[] args) {
        String url = "idea.roytrack.com";
        Integer port = 1027;
        String content = "GET http://idea.roytrack.com:1027/  HTTP/1.1\nHost:idea.roytrack.com:1027\n\n";
        sendHTTP(url,port,content);
        
    }
    
    public static void sendHTTP(String url,Integer port,String content){
        try {

            //建立TCP/IP链接
            Socket socket = new Socket(url,port);
            OutputStream out = socket.getOutputStream() ;
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            //发送数据
            out.write(content.getBytes());  
            int d = -1 ;
            //接收 输出到控制台
            while((d=in.read())!=-1){       
                System.out.print((char)d);  
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
