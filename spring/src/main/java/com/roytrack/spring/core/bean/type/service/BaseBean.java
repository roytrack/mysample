package com.roytrack.spring.core.bean.type.service;

import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2015/8/24.
 */
public interface BaseBean<T> {
    public void saySomeThing(T t);
}
