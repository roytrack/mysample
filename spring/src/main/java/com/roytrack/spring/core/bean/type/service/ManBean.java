package com.roytrack.spring.core.bean.type.service;

import com.roytrack.spring.core.bean.type.Man;

/**
 * Created by ruanchangming on 2015/8/24.
 */
public class ManBean implements BaseBean<Man>{


    @Override
    public void saySomeThing(Man man) {
        System.out.println("man say  ");
    }
}
