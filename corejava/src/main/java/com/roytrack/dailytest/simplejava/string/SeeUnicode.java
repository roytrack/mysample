package com.roytrack.dailytest.simplejava.string;

import org.apache.commons.lang3.CharUtils;

/**
 * Created by ruanchangming on 2016-3-29.
 */
public class SeeUnicode {
    public static void main(String[] args) {

        System.out.println("\\u7a0e\\u540e\\u91d1\\u989d");

        String target="万岁万岁";
        for(int i=0;i<target.length();i++){
            System.out.println(CharUtils.unicodeEscaped(target.charAt(i)));
        }

    }
}
