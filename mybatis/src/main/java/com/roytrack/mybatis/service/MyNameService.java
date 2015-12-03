package com.roytrack.mybatis.service;

import com.roytrack.mybatis.mapper.AbcMapper;
import com.roytrack.mybatis.model.Abc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实验证明 反斜杠可以被插入进去 但是单引号的是会报错的
 *
 * CREATE TABLE thename
 (
 myname VARCHAR (50) NOT NULL,
 myage  INT,
 PRIMARY KEY (myname)
 );
 *
 * Created by ruanchangming on 2015/12/3.
 */
@Service("myNameService")
public class MyNameService {
    @Autowired
    AbcMapper abcMapper;

    public void insert(){
        Abc a=new Abc();
        a.setMyname("slash\\");
        a.setMyage(2);
        abcMapper.insert(a);
        Abc b=new Abc();
        a.setMyname("quote'");
        a.setMyage(4);
        abcMapper.insert(b);
    }

    public List<Abc> selectIn(){
        String ids="'df2df','dfdf'";
        return abcMapper.selectIn(ids);
    }
}
