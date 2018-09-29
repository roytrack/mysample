package com.roytrack.dailytest.jackson.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by roytrack on 2016-12-09.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class CClass extends BClass {

  private String movieName;
  private Integer movieId;
}
