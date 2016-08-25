package com.roytrack.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ruanchangming on 2015/12/21.
 */
public class UseTemplate {
    static JedisConnectionFactory factory;
    static {
        ApplicationContext context=new FileSystemXmlApplicationContext("D:\\intelliJWP\\sample\\redis\\src\\main\\resources\\application.xml");
         factory=context.getBean("jedisConnectionFactory", JedisConnectionFactory.class);
    }
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);

        ArrayList<Future<String>> results=new ArrayList<>();
        System.out.println("开始放任务"+new Date());
        long start=System.currentTimeMillis();
        for(int i=0;i<20;i++){
            Future<String> future= service.submit(new Task());
            results.add(future);
        }
        System.out.println("放完任务"+new Date());
        int p=0;
        for(Future<String> f:results){
            while (!f.isDone()){
            }
            System.out.println("任务"+(p++)+"完成"+"   "+new Date());
        }
        long end=System.currentTimeMillis();
        System.out.println("all time cost "+(end - start));
        start=System.currentTimeMillis();
        results.clear();
        System.out.println("开始放任务" + new Date());
        for(int i=0;i<20;i++){
            Future<String> future= service.submit(new Task());
            results.add(future);
        }
        System.out.println("放完任务"+new Date());
        for(Future<String> f:results){
            while (!f.isDone()){
            }
            System.out.println("任务"+(p++)+"完成"+"   "+new Date());
        }
        service.shutdown();

    }
   static class Task implements Callable<String>{
       @Override
       public String call() throws Exception {
           for(int i=0;i<10000;i++){
               factory.getConnection().set("roy".getBytes(),"track".getBytes());
               factory.getConnection().get("roy".getBytes());


           }
           return  "";
       }
   }
}
