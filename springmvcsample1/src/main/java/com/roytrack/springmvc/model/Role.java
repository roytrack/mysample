package com.roytrack.springmvc.model;

import com.roytrack.springmvc.validation.BeanValidation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by roytrack on 2015/1/21.
 */
@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true)
public class Role {
  @BeanValidation(field = "角色名称")
  private String name;
}
