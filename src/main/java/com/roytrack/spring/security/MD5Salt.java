package com.roytrack.spring.security;

import org.junit.Test;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * Created by roytrack on 2015/1/23.
 */
public class MD5Salt {

    BasePasswordEncoder encoder=new Md5PasswordEncoder();

    @Test
    public void encodeVal(){
        System.out.println(encoder.encodePassword("sss", "sdadsadsa"));
    }


}
