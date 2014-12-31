package com.roytrack.dailytest;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试set中放入null和空字串
 * Created by ruanchangming on 2014/12/31.
 */
public class EmptyStringAndNullPutInSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        set.add(null);
        System.out.println("add null");
        System.out.println("set.size()"+set.size());
        set.add("");
        System.out.println("add '' ");
        System.out.println("set.size()"+set.size());
        System.out.println("set.contains(null)---"+set.contains(null));
        System.out.println("set.contains('')---"+set.contains(""));
        set.remove("");
        System.out.println("set.size()"+set.size());
        System.out.println("set.contains(null)---"+set.contains(null));
        System.out.println("set.contains('')---"+set.contains(""));
        set.remove(null);
        System.out.println("set.size()"+set.size());
        System.out.println("set.contains(null)---"+set.contains(null));
        System.out.println("set.contains('')---"+set.contains(""));
    }
}
