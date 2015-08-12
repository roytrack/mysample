package com.roytrack.jvm;

/**
 * Created by ruanchangming on 2015/8/12.
 */
public class DeadLoopClass{
    static{

        if(true){
            System.out.println(Thread.currentThread()+" init DeadLoopClass");
            while (true){}
        }

    }

    public static void main(String[] args) {
        Runnable script=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"  start");
                DeadLoopClass dlc=new DeadLoopClass();
                System.out.println(Thread.currentThread()+"  run over");
            }
        };
        Thread th1=new Thread(script);
        Thread th2=new Thread(script);
        th1.start();
        th2.start();
    }

}
