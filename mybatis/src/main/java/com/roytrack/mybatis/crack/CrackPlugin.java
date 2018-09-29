package com.roytrack.mybatis.crack;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Created by roytrack on 2016-08-02.
 */
public class CrackPlugin {
  public static void main(String[] args) throws Exception {
    ClassPool pool = ClassPool.getDefault();
    CtClass c = pool.get("com.seventh7.mybatis.util.JavaUtils");
    CtMethod m = c.getDeclaredMethod("refValid");
    m.setBody("{ validated = true; valid = true; return valid; }");
    c.writeFile("D:\\tmp\\999");

    CtClass cc = pool.get("com.seventh7.mybatis.service.JavaService");
    CtMethod mm = cc.getDeclaredMethod("stop");
    mm.setBody("{ return; }");
    cc.writeFile("D:\\tmp\\999");
  }
}
