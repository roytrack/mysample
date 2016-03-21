package com.roytrack.dailytest.simplejava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ruanchangming on 2015/12/16.
 */
public class RegexTest {
    public static void main(String[] args) {
        String regex="[\\w]+\\.letv\\.cn";
        Pattern r=Pattern.compile(regex);
        Matcher m=r.matcher("maven.letv.cn");
        if(m.find()){
            System.out.println(m.group());
        }

        regex="10\\.100\\.[\\d\\.]+";
        r=Pattern.compile(regex);
        m=r.matcher("10.100.112.241");
        if(m.find()){
            System.out.println(m.group());
        }

    }
}