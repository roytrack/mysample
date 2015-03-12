package com.roytrack.dailytest.simplejava.exception;

/**
 * Created by roytrack on 2015/2/18.
 */
public class TryWithSingleLine {

    public static void main(String[] args) {

        try{
            int a=10/(5-5);
        }catch (ArithmeticException e){
            System.out.println(e);
        }
    }
}
