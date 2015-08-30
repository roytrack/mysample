package com.roytrack.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roytrack on 2015/8/5.
 */
public class BadClass1 {

    static  class OOMObject {
        public byte[] placeholder=new byte[64*1024];
    }

    public  static void  fillHeap(int num) throws InterruptedException {
        List<OOMObject> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BadClass1.fillHeap(1000);
    }

}
