package com.roytrack.spring.core.bean.type.service;

import com.roytrack.spring.core.bean.type.Human;

/**
 * Created by ruanchangming on 2015/8/24.
 */
public class HumanBean implements BaseBean<Human> {
    @Override
    public void saySomeThing(Human human) {
        System.out.println("human say  ");
    }
}
