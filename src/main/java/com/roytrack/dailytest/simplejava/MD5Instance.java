package com.roytrack.dailytest.simplejava;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ruanchangming on 2015/1/27.
 */
public class MD5Instance {

    CountDownLatch l=new CountDownLatch(20);

    @Test
    public void seeInstance(){
        for(int i=0;i<20;i++){
            new md5Thread().run();
        }
    }


    class md5Thread extends Thread{
        @Override
        public void run(){
            try {
                java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
                System.out.println(alg.hashCode());
                //System.out.println(alg.digest("aaaaaa".getBytes()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
    }
}
