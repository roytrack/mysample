package com.roytrack.dailytest.simplejava.string;

import java.util.regex.Pattern;

/**
 * Created by roytrack on 2016-05-14.
 */
public class StringReplace {

    public static void main(String[] args) {
        Pattern p= Pattern.compile("^[0-9,]+$");
        String a="123,123";
        String b="122,1233,";
        String c="123，233";
        System.out.println(p.matcher(a).find());
        System.out.println(p.matcher(b).find());
        System.out.println(p.matcher(c).find());
        System.out.println(c.contains(","));
        System.out.println(c.contains("，"));
        System.out.println(a.split(",").length);
        System.out.println(b.split(",").length);
        System.out.println(c.split(",").length);
        System.out.println("-------------------");
        String d="780,799";
        System.out.println(p.matcher(d).find());
        System.out.println("-------------------");
        String e="790,799";
        System.out.println(p.matcher(e).find());

    }
}
