package com.roytrack.dailytest.net;

import org.apache.http.client.utils.URLEncodedUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by ruanchangming on 2015/4/21.
 */
public class URLRelate {

    @Test
    public void seeURL() throws UnsupportedEncodingException {
        System.out.println(
                URLDecoder.decode(
                        URLEncoder.encode(
                                "当所有的人离开我的时候,你劝我要耐心等候," +
                                        "并且陪我渡过生命中最长的寒冬,如此地宽容,当所有的人靠紧我的时候" +
                                        ",你要我安静从容,似乎知道我有一颗永不安静的心"
                                ,"UTF-8"), "UTF-8")
        );
    }
}
