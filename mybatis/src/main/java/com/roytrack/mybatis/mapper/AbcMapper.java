package com.roytrack.mybatis.mapper;

import com.roytrack.mybatis.model.Abc;
import com.roytrack.mybatis.model.QueryModel;

import java.util.List;

/**
 * Created by roytrack on 2015/12/3.
 */
public interface AbcMapper {
  int insert(Abc abc);

  List<Abc> selectIn(String ids);

  List<Abc> selectIn2(QueryModel ids);

  List<String> selectID();


}
