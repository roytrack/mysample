package com.roytrack.dailytest.simplejava.java8;

import org.junit.Test;

/**
 * Created by roytrack on 2015/2/26.
 */
public class LambdaOp {


    @Test
    public  void withoutParam(){
        StringOpInterfaceWithoutParam param=()->"return the right String";
        System.out.println(param.func());
    }

    @Test
    public void withParam(){
        OpWithParam<Integer> iOp=(n)->n*15;
        System.out.println(iOp.func(2));
    }
}
