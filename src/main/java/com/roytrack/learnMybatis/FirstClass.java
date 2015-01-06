package com.roytrack.learnMybatis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstClass {


    //201501042328 494133522
    //201501042131 293881772
    //2197426581039


    public static void main(String[] args) {
        Date s=new Date();
        System.out.println(s.getTime());
        //1420386025477
        s.setTime(1420386708028l);
        SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        System.out.println(sfd.format(s));
    }
}
