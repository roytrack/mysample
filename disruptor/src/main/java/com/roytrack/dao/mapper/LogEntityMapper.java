package com.roytrack.dao.mapper;

import com.roytrack.dao.model.LogEntity;

/**
 * Created by roytrack on 2016-09-08.
 */
public interface LogEntityMapper {


  int insert(LogEntity record);

  int insertSelective(LogEntity record);

  int updateByPrimaryKeySelective(LogEntity record);

  int updateByPrimaryKey(LogEntity record);
}
