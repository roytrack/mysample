package com.roytrack.jvm;

/**
 * Created by roytrack on 2015/8/14.
 */
public class GenericTypeWeakness {



    /***
     *
     public static void saySomething(List<String> list){

     }
     * 不能跟下面这个同时存在 编译不过去  因为泛型擦除后就一样的签名了

     public static void saySomething(List<Integer> list){

     }
     *
     *
     * **/
    /**这两个可以一起编译
     * 是因为虽然签名一样，但是在jvm里面 返回类型也是作为签名的一部分，所以可以用
     * 但不知道为什么intellij还是不编译他们
     *应该是因为我用的是1.8的javac 1.6的也许就可以了。。
     *
     *
     public static  int saySomething2(List<Integer> list){

     return 1;
     }

     public static  String saySomething2(List<String> list){

     return "";
     }

     public static void main(String[] args) {
     saySomething2(new ArrayList<Integer>());
     saySomething2(new ArrayList<String>());
     }
     *
     *
     *
     * */



}
