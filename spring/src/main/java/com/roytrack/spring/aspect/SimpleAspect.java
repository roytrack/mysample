package com.roytrack.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by roytrack on 2016-09-08.
 */
@Aspect
@Component
public class SimpleAspect {

  @Pointcut(value = "execution(* com.roytrack.spring.aspect.TargetService.saySomething(*))")
  public void pointCut1() {

  }


  @Around(value = "pointCut1()")
  public void around(ProceedingJoinPoint point) {
    System.out.println("before target method run");
    try {
      Object[] os = point.getArgs();
      os[0] = "gg";
      point.proceed(os);
      System.out.println("after target method run");
    } catch (Exception e) {
      e.printStackTrace();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }
}
