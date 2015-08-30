package com.roytrack.jvm;

import java.io.Serializable;

/**
 * Created by ruanchangming on 2015/8/12.
 */
public class OverLoad_char {

    /**第五次转化成了Object**/
//    public static void sayHello(Object arg){
//        System.out.println("hello Object");
//    }
    /**第二次转成了int**/
//    public static void sayHello(int arg){
//        System.out.println("hello int");
//    }
    /**第四次转化成了Serializable**/
//    public static void sayHello(Serializable arg){
//        System.out.println("hello Serializable");
//    }
    /**第三次转成了long*/
//    public static void sayHello(long arg){
//        System.out.println("hello long");
//    }
    /** 直接类型*/
//    public static void sayHello(char arg){
//        System.out.println("hello char");
//    }
    /**可变参数最低*/
    public static void sayHello(char... arg){
        System.out.println("hello char...");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
