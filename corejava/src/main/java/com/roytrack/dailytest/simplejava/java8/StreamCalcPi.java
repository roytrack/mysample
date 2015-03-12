package com.roytrack.dailytest.simplejava.java8;

import org.junit.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by roytrack on 2015/1/14.
 */
public class StreamCalcPi  implements Supplier<Double>{
    double sum=0;
    double current=1;
    boolean sign=true;

    @Override
    public Double get() {
        sum+=(sign?4:-4)/current;
        current+=2;
        sign=!sign;
        return sum;
    }

    @Test
    public void calcPi(){
        Stream<Double> stream=Stream.generate(new StreamCalcPi());
        stream.skip(100).limit(10).forEach(System.out::println);
    }
}
