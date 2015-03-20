package com.roytrack.dailytest.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by roytrack on 2015/3/18.
 */
public class GetDateFromOther {

    @Test
    public void getDate(){
        System.out.println(System.currentTimeMillis());
        Date d=new Date(1426644920000l);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(d));
    }

    @Test
    public void calcDate(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,100);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));
    }

}
