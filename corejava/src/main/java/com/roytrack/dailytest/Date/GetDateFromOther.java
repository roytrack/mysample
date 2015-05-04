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
import java.time.format.DateTimeFormatter;
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

    @Test
    public void getMonthBetweenTwoDate(){
        /**
         * 如果直接LocalDate.now()那么格式化的话只有年月日
         * 需要写成 LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 00:00:00"
         * */
        String beginStr="2013-02-01 00:00:00";
        String endStr="2015-05-03 00:00:00";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate begin=LocalDate.parse(beginStr, dtf);
        LocalDate now=LocalDate.parse(endStr,dtf);
        Period betweenDate=Period.between(begin,now);
        System.out.println(betweenDate.toTotalMonths() +"    "+begin.toString()+"   "+now.toString());
//        for(int i=0;i<betweenDate.toTotalMonths();i++){
//            System.out.println(begin.toString());
//            begin=begin.plusMonths(1);
//        }
        //获取两个日期之间的所有月 两边都是闭区间
        for(int i=0;begin.isBefore(now);i++){
            if(i>0){
                begin=begin.plusMonths(1);
                if(begin.isAfter(now)){
                    break;
                }
            }
            System.out.println(begin.format(DateTimeFormatter.ofPattern("yyyyMM")));
            System.out.println(begin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }






    }

}
