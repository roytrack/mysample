package com.roytrack.dailytest.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

        logger.info("距离发现此bug已过去{}月{}天，共{}天", betweenDate.getMonths(), betweenDate.getDays(),
                LocalDate.now().toEpochDay() - begin.toEpochDay());
    }

    @Test
    public void getMonthBetweenTwoDate(){
        /**
         * 如果直接LocalDate.now()那么格式化的话只有年月日
         * 需要写成 LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 00:00:00"
         * */
        String beginStr="2013-02-05 00:00:00";
        String endStr="2015-05-03 00:00:00";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter fullDate=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter yearMonth=DateTimeFormatter.ofPattern("yyyyMM");
        LocalDate begin=LocalDate.parse(beginStr, dtf);
        LocalDate now=LocalDate.parse(endStr,dtf);
        Period betweenDate=Period.between(begin,now);
        System.out.println(betweenDate.toTotalMonths() +"    "+begin.toString()+"   "+now.toString());
//        for(int i=0;i<betweenDate.toTotalMonths();i++){
//            System.out.println(begin.toString());
//            begin=begin.plusMonths(1);
//        }

        System.out.println("aa".compareTo("ab"));
        //获取两个日期之间的所有月 两边都是闭区间
        for(int i=0;begin.format(yearMonth).compareTo(now.format(yearMonth)) <=0;i++){
            System.out.println(begin.format(yearMonth));
            System.out.println(begin.format(fullDate));
            begin=begin.plusMonths(1);
        }
        System.out.println("################################");
        LocalDate theBegin=LocalDate.of(2013,4,29);
        LocalDate theEnd=LocalDate.of(2015,5,5);
        //比月份你就按照月份比 别按照日期比 肯定出事哦
        while(theBegin.format(yearMonth).compareTo(theEnd.format(yearMonth))<=0){
            System.out.println(theBegin);
            theBegin=theBegin.plusMonths(1);
        }
    }

    @Test
    public void getTimeByjdkLow() throws ParseException {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(d));
        String demoDate="2015-02-23 15:5:40";
        Date demod=sdf.parse(demoDate);
        System.out.println(sdf.format(demod));
    }

    @Test
    public void addDayCrossMonth(){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
        System.out.println(sdf.format(DateUtils.addDays(d,29)));
        System.out.println(sdf.format(DateUtils.addDays(d,-29)));
    }

    @Test
    public void timeMills(){
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void getDateString(){

        Calendar c=new GregorianCalendar(2015,1,28);
        Date date=c.getTime();
        String beginTime = DateFormatUtils.format(DateUtils.addDays(date, -30), "yyyy-MM-dd 00:00:00");
        String endTime = DateFormatUtils.format(DateUtils.addDays(date, -29), "yyyy-MM-dd 00:00:00");
        System.out.println(beginTime);
        System.out.println(endTime);
        date=DateUtils.addDays(date,1);
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd 00:00:00"));
         beginTime = DateFormatUtils.format(DateUtils.addDays(date, -30), "yyyy-MM-dd 00:00:00");
         endTime = DateFormatUtils.format(DateUtils.addDays(date, -29), "yyyy-MM-dd 00:00:00");
        System.out.println(beginTime);
        System.out.println(endTime);
        date=DateUtils.addDays(date,1);
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd 00:00:00"));
        beginTime = DateFormatUtils.format(DateUtils.addDays(date, -30), "yyyy-MM-dd 00:00:00");
        endTime = DateFormatUtils.format(DateUtils.addDays(date, -29), "yyyy-MM-dd 00:00:00");
        System.out.println(beginTime);
        System.out.println(endTime);
    }

}

