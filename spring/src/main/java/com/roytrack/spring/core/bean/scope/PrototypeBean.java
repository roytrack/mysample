package com.roytrack.spring.core.bean.scope;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2016-08-03.
 */
@Service
@Scope("prototype")
@Getter
@Setter
public class PrototypeBean {
    private String name ;
    private int age;
}
