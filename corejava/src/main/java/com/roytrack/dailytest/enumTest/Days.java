package com.roytrack.dailytest.enumTest;

/**
 * Created by roytrack on 2015/8/30.
 */
enum Days {
   Monday(1),Tuesday(2),Wednesday(3),Thursday(4),Friday(5),Saturday(6),Sunday(7);
    private int dayOrder;
    Days(int dayOrder){
        this.dayOrder=dayOrder;
    }
    Days(){
        this.dayOrder=-1;
    }


    public boolean equal(Days d){
        return equals(d);
    }

    public static void main(String[] args) {
        System.out.println(Days.values());
        System.out.println(Days.Monday);
        System.out.println(Days.Friday.dayOrder);
        System.out.println(Days.valueOf("Monday"));
        // java.lang.IllegalArgumentException: No enum constant com.roytrack.dailytest.enumTest.Days.ppp
        //System.out.println(Days.valueOf("ppp"));
        System.out.println(Monday.equal(Monday));
    }
}
