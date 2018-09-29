package com.roytrack.dailytest;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by roytrack on 2015/1/11.
 */
public class CommonLangDateParse {
  @Test
  public void parseDate() throws ParseException {
    String date = "2014/12/12";
    Date d = DateUtils.parseDateStrictly(date, "yyyy/MM/dd");
    System.out.println(DateFormatUtils.format(d, "yyyy-MM-dd"));
  }

}

