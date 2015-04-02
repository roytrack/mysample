package com.roytrack.dailytest.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by roytrack on 2015/3/18.
 */
public class GetDateFromOther {
    Logger logger= LoggerFactory.getLogger(GetDateFromOther.class);

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

    @Test
    public void calcDateBetweenTwoDate(){
        LocalDate begin=LocalDate.of(2014,9,25);
        LocalDate now=LocalDate.now();
        Period betweenDate=Period.between(begin,now);
        logger.info("距离发现此bug已过去{}月{}天，共{}天",betweenDate.getMonths(),betweenDate.getDays(),
                LocalDate.now().toEpochDay()-begin.toEpochDay());
    }

}
