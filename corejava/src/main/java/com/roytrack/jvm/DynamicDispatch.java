package com.roytrack.jvm;

/**
 * Created by roytrack on 2015/8/13.
 */
public class DynamicDispatch {

    static class Human{
        public void sayHello(){
            System.out.println("hello human");
        }
    }
    static  class Man extends Human{
        public void sayHello(){
            System.out.println("hello Man");
        }
    }
    static class Woman extends Human{
        public  void sayHello(){
            System.out.println("hello Woman");
        }
    }

    public static void main(String[] args) {
        Human man=new Man();
        Human woman=new Woman();
        man.sayHello();
        woman.sayHello();
        man=new Woman();
        man.sayHello();
    }
}
