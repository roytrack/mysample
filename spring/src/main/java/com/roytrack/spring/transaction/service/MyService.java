package com.roytrack.spring.transaction.service;

import com.roytrack.spring.transaction.mapper.boo.BooMapper;
import com.roytrack.spring.transaction.mapper.foo.FooMapper;
import com.roytrack.spring.transaction.mapper.ooo.OooMapper;
import com.roytrack.spring.transaction.model.boo.Boo;
import com.roytrack.spring.transaction.model.foo.Foo;
import com.roytrack.spring.transaction.model.ooo.Ooo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 *
 * Created by ruanchangming on 2015/5/4.
 */
@Service
public class MyService {

    @Resource
    BooMapper booMapper;
    @Resource
    FooMapper fooMapper;
    @Resource
    OooMapper oooMapper;


    /***
     * mysql不同数据库的不同mapper 在同一事务中会同时回滚
     * **/
    public  void makeCrossTransaction(){
        Boo b=new Boo();
        b.setMyaccount(22);
        b.setMyname("ccd");
        booMapper.updateStatus(b);
        Foo f=new Foo();
        f.setProName("eef");
        f.setProSum(929);
        fooMapper.updateStatus(f);
//        Object a=null;
//        if(a.equals("ss")){
//        }

    }

    public void makeCrossTransactionWithOracleMysql(){
        Foo f=new Foo();
        f.setProName("eef");
        f.setProSum(929);
        fooMapper.updateStatus(f);
        Ooo o=new Ooo();
        o.setOrderName("ggh");
        o.setOrderSum(895);
        oooMapper.updateStatus(o);

                Object a=null;
        if(a.equals("ss")){
        }
    }
}
