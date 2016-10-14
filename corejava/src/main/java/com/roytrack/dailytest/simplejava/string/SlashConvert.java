package com.roytrack.dailytest.simplejava.string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by roytrack on 2015/12/3.
 */
public class SlashConvert {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("D:\\intelliJWP\\sample\\corejava\\src\\main\\resources\\abc.properties"));

            System.out.println(prop.getProperty("str1"));
            System.out.println(prop.getProperty("str2"));
            String ddd="ccdgd\\";
            System.out.println(ddd);
            ddd=ddd.replaceAll("\\\\", "\\\\\\\\");
            System.out.println(ddd);
            String ee=prop.getProperty("str2");
            ee=ee.replaceAll("\\\\","\\\\\\\\");
            System.out.println(ee);
            ee.replace("\\","\\\\\\\\");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
