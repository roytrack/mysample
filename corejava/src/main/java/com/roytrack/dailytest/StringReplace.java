package com.roytrack.dailytest;

import java.io.File;

/**
 * 替换路径尾部
 * Created by roytrack on 2015/1/5.
 */
public class StringReplace {
  public static void main(String[] args) {
    //无能的replace
    String aa = "D:/upload_bak/admin/1420448554181";
    System.out.println(aa.replace("D;/upload_bak/", "D:/download_bak/"));
    //根据两层父路径弄到后面两部分 然后就可以拼接 截取了
    File f = new File("D:\\dev_tool\\apache-tomcat-8.0.15\\bin\\upload_bak\\admin\\1420448554181");
    System.out.println(f.getParent());
    String allpath = f.getAbsolutePath();
    String parentOne = f.getParent();
    File fp = f.getParentFile();
    String parentTwo = fp.getParent();
    System.out.println(allpath + "@@@@" + parentOne + "@@@@" + parentTwo);
    System.out.println(f.getAbsolutePath().substring(f.getParentFile().getParent().length()));

  }
}
