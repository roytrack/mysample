package com.roytrack.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by roytrack on 2016-09-08.
 */
@Aspect
public class SimpleAspect {

    @Pointcut(value ="execution(* com.roytrack.spring.aspect.TargetService.saySomething(*))&&args(cc)", argNames = "cc")
    public void pointCut1(String cc){

    }


    @Around(value = "pointCut1(cc)" )
    public void around(ProceedingJoinPoint point,String cc){
        System.out.println("before target method run");
        try{
            Object[] os=new Object[1];
            os[0]=cc;
            point.proceed(os);
            System.out.println("after target method run");
        }catch (Exception e){
         e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
