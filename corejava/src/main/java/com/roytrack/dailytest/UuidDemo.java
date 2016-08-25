package com.roytrack.dailytest;


import com.fasterxml.uuid.Generators;

import java.util.UUID;

/**
 * Created by roytrack on 2016/8/25.
 */
public class UuidDemo {
    public static void main(String[] args) {

        UUID uuid = new UUID(1111l, 5l);
        System.out.println(uuid.version());
        String aa = uuid.toString();
        System.out.println(aa);

        for (int i = 0; i < 1000; i++) {
            String aaa = Generators.randomBasedGenerator().generate().toString();
            System.out.println(aaa);

//            aa = UUID.randomUUID().toString();
//            System.out.println(aa);


        }

    }
}
