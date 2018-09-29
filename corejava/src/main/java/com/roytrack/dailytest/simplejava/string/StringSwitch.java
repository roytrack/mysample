package com.roytrack.dailytest.simplejava.string;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by roytrack on 2015/4/23.
 */
public class StringSwitch {
  private static Logger logger = LoggerFactory.getLogger(StringSwitch.class);

  @Test
  public void switchOriginalString() {
    String foo = "bbc";
    switch (foo) {
      case "abc":
        logger.info("this is a abc");
        break;
      case "bbc":
        logger.info("this is a bbc");
        break;
      case "cbc":
        logger.info("this is a cbc");
      default:
        logger.info("this is default");
    }
  }

  @Test
  public void switchWithEnum() {
    Week week = Week.TUESDAY;
    switch (week) {
      case MONDAY:
        logger.info(Week.MONDAY.getValue());
        break;
      case TUESDAY:
        logger.info(Week.TUESDAY.getValue());
        break;
      case WEDNESDAY:
        logger.info(Week.WEDNESDAY.getValue());
        break;
      case THURSDAY:
        logger.info(Week.THURSDAY.getValue());
        break;
      case FRIDAY:
        logger.info(Week.FRIDAY.getValue());
        break;
      case SATURDAY:
        logger.info(Week.SATURDAY.getValue());
        break;
      case SUNDAY:
        logger.info(Week.SUNDAY.getValue());
      default:
        logger.info("not in week day");

    }
  }

  enum Week {
    MONDAY("monday"), TUESDAY("tuesday"),
    WEDNESDAY("wednesday"), THURSDAY("thursday"),
    FRIDAY("friday"), SATURDAY("saturday"), SUNDAY("sunday");

    private String value;

    private Week(String value) {
      this.value = value;
    }

    public static Week getDay(String v) {
      Week w = null;
      for (Week l : Week.values()) {
        if (l.getValue().equals(v)) {
          w = l;
        }
      }
      return w;
    }

    public String getValue() {
      return this.value;
    }
  }
}
