package com.roytrack.dailytest.number;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by roytrack on 2016-08-11.
 */
public class RandomTest {

    @Test
    public void testInt(){
        Random r=new Random();
        for(int i=0;i<100;i++){
            System.out.println(r.nextInt());
        }
    }

    // get random number between 300-900
    @Test
    public  void getRangeRandom(){
        SecureRandom random=new SecureRandom();
        IntStream stream=random.ints(300, 900);
        stream.forEach(s -> System.out.println(s));


    }

}
