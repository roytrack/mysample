package com.roytrack.spring.core.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by roytrack on 2015/5/6.
 */
public class FirstBean {
    @Value("${sss}")
    public String testStr="testStr";
    public String getTestStr(){
        return testStr;
    }
    public void setTestStr(String testStr){
        this.testStr=testStr;
    }
}


