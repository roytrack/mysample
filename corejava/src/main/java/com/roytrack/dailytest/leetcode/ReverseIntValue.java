package com.roytrack.dailytest.leetcode;

/**
 * Created by roytrack on 2016-06-18.
 */
public class ReverseIntValue {

    public static void main(String[] args) {
        int p=123456789;
        int a=reverse(p);
        System.out.println(a);

    }

    public static int reverse(int i){

        System.out.println(i);
        System.out.println(i%10+"   "+(i%10)*100000000 +"  "+(i/10)+"  "+(i%10)*Double.valueOf(Math.pow(10,String.valueOf(i).length()-1)).intValue()+
        "  "+(double)(i%10)+"   "+(double)String.valueOf(i).length());
        if(i>10){
            return (i%10)*Double.valueOf(Math.pow(10,(double)String.valueOf(i).length()-1)).intValue()+reverse(i/10);
        }else{
            return i;
        }
//        int q=i%10;
//        if(i%10!=1){
//            q=q*100000000+i/10;
//            reverse(q);
//        }
//        return q;
    }
}
