package com.roytrack.spring.custiomize.xml;


import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;


/**
 * Created by roytrack on 2015/5/19.
 */
public class RoyDefinitionParser extends AbstractSingleBeanDefinitionParser {
    protected Class getBeanClass(Element element) {
        return PersonVo.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String id = element.getAttribute("id");
        bean.addPropertyValue("id", id);
        bean.addPropertyValue("thename",element.getAttribute("thename"));
        bean.addPropertyValue("age",element.getAttribute("age"));
        bean.addPropertyValue("address",element.getAttribute("address"));
    }

}
