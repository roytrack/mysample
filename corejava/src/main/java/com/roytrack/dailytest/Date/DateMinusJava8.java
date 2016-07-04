package com.roytrack.dailytest.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * Created by roytrack on 2016-07-01.
 */
public class DateMinusJava8 {

    public static void main(String[] args) {
        Date date = new Date();
//        String beginTime = "2015-7-1 00:00:00" ;
//        String endTime = "2015-8-1 00:00:00" ;
        String beginTime = DateFormatUtils.format(DateUtils.addDays(date, -30), "yyyy-MM-dd 00:00:00");
        String endTime = DateFormatUtils.format(DateUtils.addDays(date, -29), "yyyy-MM-dd 00:00:00");
        System.out.println(beginTime);
        System.out.println(endTime);
    }
}
