package com.roytrack.springmvc.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by roytrack on 2015/1/21.
 */
public class BeanValidator implements ConstraintValidator<BeanValidation, String> {
  @Override
  public void initialize(BeanValidation constraintAnnotation) {

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) return Boolean.TRUE;
    return !StringUtils.trim(value).equals("哈哈哈");
  }


}
