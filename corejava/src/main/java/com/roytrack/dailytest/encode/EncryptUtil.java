package com.roytrack.dailytest.encode;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by roytrack on 2017/9/22.
 */
public class EncryptUtil {
    private static String KEY = "1234567890123456";
    private static String CHARSET = "utf-8";

    public static String encrypt(String content) throws UnsupportedEncodingException {
        return Base64.encode(AesEncrypt.encrypt(content.getBytes(CHARSET), KEY.getBytes()));

    }

    public static String decrypt(String content) throws UnsupportedEncodingException {
        byte[] buffer = AesEncrypt.decrypt(Base64.decode(content), KEY.getBytes());
        String result = new String(buffer, CHARSET);
        return result;
    }

    public static String encrypt(String content, String password) throws UnsupportedEncodingException {
        return Base64.encode(AesEncrypt.encrypt(content.getBytes(CHARSET), password.getBytes()));
    }

    public static String decrypt(String content, String password) throws UnsupportedEncodingException {
        byte[] buffer = AesEncrypt.decrypt(Base64.decode(content), password.getBytes());
        String result = new String(buffer, CHARSET);
        return result;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
           String origin = "我的生活";
//        System.out.println("origin=" + origin);
//        try {
//            String encrypt = encrypt(origin);
//            System.out.println("encrypt=" + encrypt);
//            System.out.println("base64code=" + Base64.encode(origin.getBytes(CHARSET)));
//            System.out.println(origin.equals(decrypt(encrypt)) ? "equal" : "Not equal");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        byte[] password=origin.getBytes("utf-8");
        SecureRandom sRandom = SecureRandom.getInstance("SHA1PRNG");
        sRandom.setSeed(password);
        byte[] randomBytes = password.clone();
        System.out.println(StringUtils.join(randomBytes,','));
        sRandom.nextBytes(randomBytes);
        System.out.println(StringUtils.join(randomBytes, ','));
    }
}
