package com.roytrack.dailytest.simplejava.concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * Created by roytrack on 2015/4/15.
 */
public class SemaphoreDemo {

    Semaphore sem=new Semaphore(0);
    @Test
    public  void TestRelease(){
        for(int i=0;i<10;i++){
            sem.release();
        }
        System.out.println(sem.availablePermits());
    }

}
class SemoDemo{
    public static void main(String[] args) {
        Semaphore sem=new Semaphore(1);
        new IncThread(sem,"addThread");
        new DecThread(sem,"DecThread");
    }

}
class  Shared{
static int count=0;
        }

class IncThread implements Runnable{
    String name;
    Semaphore sem;
    IncThread(Semaphore s,String n){
        sem=s;
        name=n;
        new Thread(this,name).start();
    }
    public  void run(){
        System.out.println("Starting "+name);

        try {
            System.out.println(name+" is waiting for  a permit.");
            sem.acquire();
            System.out.println(name+" gets a permit");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + " : " + Shared.count);
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            System.out.println("this thread "+name+" is interrupt .description :"+e);
        }
        System.out.println(name+" releases this permit");
        sem.release();
    }
}
class DecThread implements Runnable{
    String name;
    Semaphore sem;
    DecThread(Semaphore s,String n){
        name=n;
        sem=s;
        new Thread(this,name).start();
    }
    public void run(){
        System.out.println("Starting "+name);
        try {
            System.out.println(name+" is waiting for a permit");
            sem.acquire();
            System.out.println(name + " gets a permit");

        for(int i=0;i<5;i++){
            Shared.count--;
            System.out.println(name+" : "+Shared.count);
            Thread.sleep(10);
            if(i==3)throw new InterruptedException();

        }
        } catch (InterruptedException e) {
            System.out.println("this thread " + Thread.currentThread().getName() + " is interrupt .description :" + e);
        }
        System.out.println(name+" releases this permit");
        sem.release();
    }
}