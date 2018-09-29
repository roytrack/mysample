package com.roytrack.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by roytrack on 2016-09-09.
 */
@Aspect
@Component
public class AnnotationAdvice {

  @Before(value = "execution(* com.roytrack.spring.aspect.AnnotationService.say())")
  public void before() {
    System.out.println("this is before");
  }

  @After(value = "execution(* com.roytrack.spring.aspect.AnnotationService.say())")
  public void after() {
    System.out.println("this is after");
  }

  @Around(value = "execution(* com.roytrack.spring.aspect.AnnotationService.sayWithParam(*))")
  public void arount(ProceedingJoinPoint point) {
    Object[] os = point.getArgs();
    String aa = String.valueOf(os[0]);
    System.out.println("this is around before" + aa);
    try {

      point.proceed();
    } catch (Exception e) {
      e.printStackTrace();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    System.out.println("this is around after");

  }
}
