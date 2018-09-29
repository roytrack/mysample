package com.roytrack.netty.encode_6_1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by roytrack on 2016-10-17.
 */
public class TestUserInfo {
  public static void main(String[] args) throws IOException {
    UserInfo info = new UserInfo();
    info.buildUserId(100).buildUserName("roytrack");
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(info);
    oos.flush();
    oos.close();
    byte[] b = bos.toByteArray();
    System.out.println("The jdk serializable length is " + b.length);
    bos.close();
    System.out.println("----------------------------------------------------");
    System.out.println("The byte array serializable length is " + info.codeC().length);
  }
}
