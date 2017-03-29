package com.roytrack.mq;

/**
 * Created by roytrack on 2017-03-29.
 */
public class AccessDbThread implements Runnable {

    private String msg;

    public AccessDbThread(String msg){
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg=msg;
    }

    @Override
    public void run() {
        System.out.println("Added the message :"+msg+"into the Database");
    }
}
