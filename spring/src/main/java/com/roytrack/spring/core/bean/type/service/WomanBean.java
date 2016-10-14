package com.roytrack.spring.core.bean.type.service;

import com.roytrack.spring.core.bean.type.Woman;

/**
 * Created by roytrack on 2015/8/24.
 */
public class WomanBean implements BaseBean<Woman> {
    @Override
    public void saySomeThing(Woman woman) {
        System.out.println("woman say  ");
    }
}
