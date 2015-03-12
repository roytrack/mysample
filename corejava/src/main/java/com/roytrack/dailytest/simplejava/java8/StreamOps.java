package com.roytrack.dailytest.simplejava.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by roytrack on 2015/1/14.
 */
public class StreamOps {

    @Test
    public void listOp(){
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> twoEvenSquares=numbers.stream().filter(n -> {
            System.out.println("filtering---" + n);
            return n % 2 == 0;
        }).map(n -> {
            System.out.println("mapping---" + n);
            return n * n;
        }).limit(2).collect(toList());
        System.out.println(twoEvenSquares.toString());
    }

    @Test
    public void listOp2(){
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8);
      numbers.stream().filter(n -> {
            return n % 2 == 0;
        }).map(n -> {
            return n * n;
        }).forEach(System.out::println);

    }
}
