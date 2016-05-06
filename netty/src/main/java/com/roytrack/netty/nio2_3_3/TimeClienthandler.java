package com.roytrack.netty.nio2_3_3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ruanchangming on 2016-3-24.
 */
public class TimeClienthandler implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile  boolean stop;


    public TimeClienthandler(String ip, int port) {
        this.host=ip==null?"127.0.0.1":ip;
        this.port=port;
        try{
            selector=Selector.open();
            socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        AtomicInteger integer=new AtomicInteger(0);
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop=false;
            try {
                doConnect();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            while (!stop){
                try {
                    selector.select(1000);
                    Set<SelectionKey> selectedKey=selector.selectedKeys();
                    Iterator<SelectionKey> itr=selectedKey.iterator();
                    SelectionKey key=null;
                    while (itr.hasNext()){
                        key=itr.next();
                        itr.remove();
                        try{
                            handleInput(key);
                        }catch (Exception e){
                            if(key!=null){
                                key.cancel();
                                if(key.channel()!=null){
                                    key.channel().close();
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }

            integer.incrementAndGet();
            if(integer.get()==10000)break;
        }
        if(selector!=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            SocketChannel sc=(SocketChannel)key.channel();
            if(key.isConnectable()){
                if(sc.finishConnect()){
                    sc.register(selector,SelectionKey.OP_READ);
                    doWrite(sc);
                }else{
                    System.exit(1);
                }
            }
            if(key.isReadable()){
                ByteBuffer readBuffer=ByteBuffer.allocate(1024);
                int readBytes=sc.read(readBuffer);
                if(readBytes>0){
                    readBuffer.flip();
                    byte[] bytes=new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body=new String (bytes,"UTF-8");
                    System.out.println("now is : "+body);
                    this.stop=true;
                }else if(readBytes <0){
                    key.channel();
                    sc.close();
                }
            }else{

            }

        }
    }


    private void doConnect() throws IOException {
        boolean connectionStatus=false;
        if(socketChannel.isConnected()){
            connectionStatus=true;
        }else{
            connectionStatus=socketChannel.connect(new InetSocketAddress(host,port));
        }
        if(connectionStatus){
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        }else{
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel sc) throws IOException {
        Random r=new Random();
        byte [] req= r.nextInt()%2==0?"time".getBytes():"boo foo".getBytes();
        ByteBuffer byteBuffer=ByteBuffer.allocate(req.length);
        byteBuffer.put(req);
        byteBuffer.flip();
        sc.write(byteBuffer);
        if(!byteBuffer.hasRemaining()){
            System.out.println("Send order to server succeed . order is "+new String(req));
        }

    }


}
