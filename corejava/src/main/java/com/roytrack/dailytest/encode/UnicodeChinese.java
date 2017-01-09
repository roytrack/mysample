package com.roytrack.dailytest.encode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roytrack on 2016/10/18.
 */
public class UnicodeChinese {
    public static void main(String[] args) {
        String demo="湘江北岸，橘子洲头";

        System.out.println(stringToUnicode(demo));
        System.out.println(unicodeToString(stringToUnicode(demo)));
    }
    /*

 *  把中文字符串转换为十六进制Unicode编码字符串

 */

    public static String stringToUnicode(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            if (ch > 255)
                str += "\\u" + Integer.toHexString(ch);
            else
                str += "\\" + Integer.toHexString(ch);
        }
        return str;
    }



/*

 *  把十六进制Unicode编码字符串转换为中文字符串

 */

    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

        Matcher matcher = pattern.matcher(str);

        char ch;

        while (matcher.find()) {

            ch = (char) Integer.parseInt(matcher.group(2), 16);

            str = str.replace(matcher.group(1), ch + "");

        }

        return str;

    }


}
