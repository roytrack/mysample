package com.roytrack.spring.aspect;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2016-09-09.
 */
@Service
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AnnotationService {

    public void say(){
        System.out.println("with annotation");
    }

    public void sayWithParam(String aa){
        System.out.println("with param "+aa);
    }
}
