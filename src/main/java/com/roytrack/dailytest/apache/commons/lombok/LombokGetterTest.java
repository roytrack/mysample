package com.roytrack.dailytest.apache.commons.lombok;

import org.junit.Test;

/**
 * 如果自己有getter lombok不会去重写这个getter
 * Created by ruanchangming on 2015/1/11.
 */
public class LombokGetterTest {
    @Test
    public  void  HowToDoWithAClassHaveGetter(){
        AbeanHaveGetter bean=new AbeanHaveGetter();
        bean.setFoo("sss");
        bean.setName("ooo");
        System.out.println(bean.toString());
    }
}
