package com.roytrack.dailytest.simplejava;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by roytrack on 2015/1/19.
 */
public class List2Array {

    @Test
    public void list2Array(){
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String[] array=list.toArray(new String[list.size()]);
        for(String s:array)
        System.out.println(s);

    }

    @Test
    public  void array2List(){
        String [] array=new String[]{"aa","bb","cc"};
        List<String> list= Arrays.asList(array);
        System.out.println(list);
    }
    @Test
    public void arrayRemove(){
        String [] array=new String[]{"aa","bb","cc"};
        array=  ArrayUtils.add(array,"ss");
        for(String s:array)
            System.out.println(s);
        System.out.println("==================");
        String[] arr2=ArrayUtils.removeAll(array,1,3);
        for(String s:arr2)
            System.out.println(s);

    }

}
