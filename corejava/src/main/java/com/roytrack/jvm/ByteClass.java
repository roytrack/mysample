package com.roytrack.jvm;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ruanchangming on 2015/8/5.
 */
public class ByteClass {

    private int m;
    public int inc(){
        return m+1;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String aaa=URLEncoder.encode("http://abc.com/a=5%&b=4%","UTF-8");
        System.out.println(aaa);
    }
}
