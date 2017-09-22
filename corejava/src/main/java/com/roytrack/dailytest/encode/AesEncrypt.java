package com.roytrack.dailytest.encode;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by roytrack on 2017/9/22.
 */
public class AesEncrypt {

    public static byte[] encrypt(byte[] content, byte[] password) {
        return aesCrypt(1, content, password);
    }

    public static byte[] decrypt(byte[] content, byte[] password) {
        return aesCrypt(2, content, password);
    }

    protected static byte[] aesCrypt(int mode, byte[] content, byte[] password) {
        try {
            SecureRandom sRandom = SecureRandom.getInstance("SHA1PRNG");
            sRandom.setSeed(password);
            byte[] randomBytes = password.clone();
            sRandom.nextBytes(randomBytes);
            SecretKeySpec key = new SecretKeySpec(randomBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
