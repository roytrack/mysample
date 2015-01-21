package com.roytrack.springmvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * Created by roytrack on 2015/1/21.
 */
@Documented
@Constraint(validatedBy = {BeanValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface BeanValidation {
    String message() default "ssss";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field() default "";
}
