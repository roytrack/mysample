package com.roytrack.spring.custiomize.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by ruanchangming on 2015/5/19.
 */
public class RoyNamespaceHandlerSupport extends NamespaceHandlerSupport {
    @Override
    public void init() {
            registerBeanDefinitionParser("roy",new RoyDefinitionParser());
    }
}
