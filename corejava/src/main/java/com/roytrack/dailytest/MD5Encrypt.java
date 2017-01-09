package com.roytrack.dailytest;

import org.junit.Test;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 测试md5加密效率
 * Created by roytrack on 2015/1/23.
 */
public class MD5Encrypt {

    @Test
    public void encodeEfficiency(){
        BasePasswordEncoder encoder=new Md5PasswordEncoder();
        Long start=System.currentTimeMillis();
        System.out.println(start);
        for(int i=0;i<100000;i++){
            encoder.encodePassword("床前明月光，疑是地上霜。举头望明月，低头思故乡。","lady@gaga&popo");
        }
        System.out.println("加密10万次:"+(System.currentTimeMillis()-start)+"毫秒");
        start=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            encoder.encodePassword("床前明月光，疑是地上霜。举头望明月，低头思故乡。", "lady@gaga&popo");
        }
        System.out.println("加密1万次:"+(System.currentTimeMillis()-start)+"毫秒");
        start=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            encoder.encodePassword("床前明月光，疑是地上霜。举头望明月，低头思故乡。", "lady@gaga&popo");
        }
        System.out.println("加密1000次:"+(System.currentTimeMillis()-start)+"毫秒");
        start=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            encoder.encodePassword("床前明月光，疑是地上霜。举头望明月，低头思故乡。", "lady@gaga&popo");
        }
        System.out.println("加密100次:"+(System.currentTimeMillis()-start)+"毫秒");
        start=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            encoder.encodePassword("床前明月光，疑是地上霜。举头望明月，低头思故乡。", "lady@gaga&popo");
        }
        System.out.println("加密10次:"+(System.currentTimeMillis()-start)+"毫秒");
        for(int i=0;i<1;i++){
            encoder.encodePassword("床前明月光，疑是地上霜。举头望明月，低头思故乡。","lady@gaga&popo");
        }
        System.out.println("加密1次:"+(System.currentTimeMillis()-start)+"毫秒");

    }

    @Test
    public void showMd5() throws NoSuchAlgorithmException{
        String ps="6666";
        java.security.MessageDigest alg = MessageDigest.getInstance("MD5");
        alg.update(ps.getBytes());
        System.out.println(Hex.encode(alg.digest()));
    }

}
