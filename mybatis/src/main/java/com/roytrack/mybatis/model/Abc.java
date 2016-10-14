package com.roytrack.mybatis.model;

import lombok.ToString;

/**
 * Created by roytrack on 2015/12/3.
 */
@ToString
public class Abc {
    private String myname;
    private Integer myage;

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public Integer getMyage() {
        return myage;
    }

    public void setMyage(Integer myage) {
        this.myage = myage;
    }
}
