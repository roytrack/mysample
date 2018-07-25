package com.roytrack.disruptor.startup;

import java.time.Instant;

/**
 * Created by roytrack on 2016-08-23.
 */
public class CompareToPrimeType {

    public static void main(String[] args) {
        Long start=System.nanoTime();
        for (long l = 0L; l < 100000L; l++) {
        }
        System.out.println(System.nanoTime()-start);
        System.out.println(Instant.now().toEpochMilli());
    }

}
