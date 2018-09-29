package com.roytrack.spring.aspect;

import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2016-09-08.
 */
@Service
public class TargetService {

  public void saySomething(String cc) {
    System.out.println("this is a good day  " + cc);
  }

  public void noParam() {
    System.out.println(" no param test");
  }
}
