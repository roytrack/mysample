package com.roytrack.dailytest.simplejava.string;

import java.util.regex.Pattern;

/**
 * Created by ruanchangming on 2016-05-14.
 */
public class StringReplace {

    public static void main(String[] args) {
        Pattern p= Pattern.compile("^[1-9,]+$");
        String a="123,1233";
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

    }
}
