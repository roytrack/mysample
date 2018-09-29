package com.roytrack.dailytest.apache.commons.logback;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * test  email to report logger error level
 * Created by roytrack on 2015/6/8.
 */
public class FailEmail {
  protected static final Logger logger = LoggerFactory.getLogger(FailEmail.class);


  @Test
  public void errorLevelLog() {
    try {
      int a = 1 / 0;
    } catch (Exception e) {
      logger.error("Plz send the email {}", e);
      throw e;
    }

  }


}
