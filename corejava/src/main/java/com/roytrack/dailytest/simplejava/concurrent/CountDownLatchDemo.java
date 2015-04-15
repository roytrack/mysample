package com.roytrack.dailytest.simplejava.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by roytrack on 2015/4/15.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(5);
        new MyThread(latch,"500T",500);
        new MyThread(latch,"1000T",1000);
        new MyThread(latch,"100T",100);
        new MyThread(latch,"10000T",10000);
        new MyThread(latch,"5000T",5000);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

}

class MyThread implements  Runnable{
    CountDownLatch latch;
    long sleepTime;

    MyThread(CountDownLatch l,String name,long s){
        latch=l;
        new Thread(this,name).start();
        sleepTime=s;

    }
    public void run(){
        System.out.println(Thread.currentThread().getName() +" is run");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"  wakes up");
        latch.countDown();
        System.out.println(Thread.currentThread().getName()+ " make latch" +latch.getCount());
    }

}
