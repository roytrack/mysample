package com.roytrack.springmvc.validation;

import org.hibernate.validator.util.annotationfactory.AnnotationDescriptor;
import org.hibernate.validator.util.annotationfactory.AnnotationFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by roytrack on 2015/1/21.
 */
public class ValidationTest {

    @Test
    public void test(){
        AnnotationDescriptor<BeanValidation> descriptor=new AnnotationDescriptor<BeanValidation>(BeanValidation.class);
        BeanValidation bv= AnnotationFactory.create(descriptor);
        BeanValidator beanValidator=new BeanValidator();
        beanValidator.initialize(bv);
        Assert.assertTrue(beanValidator.isValid(null, null));
        Assert.assertTrue(beanValidator.isValid("",null));
        Assert.assertTrue(beanValidator.isValid("哈哈哈1",null));
        Assert.assertFalse(beanValidator.isValid("哈哈哈",null));


    }
}
