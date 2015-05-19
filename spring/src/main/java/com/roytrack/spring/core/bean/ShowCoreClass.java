package com.roytrack.spring.core.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.support.FactoryBeanRegistrySupport;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.AliasRegistry;
import org.springframework.core.SimpleAliasRegistry;

/**
 * Created by roytrack on 2015/5/6.
 */
public class ShowCoreClass {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory );
        FileSystemXmlApplicationContext context=new FileSystemXmlApplicationContext();
        AliasRegistry a=new AliasRegistry() {
            @Override
            public void registerAlias(String name, String alias) {

            }

            @Override
            public void removeAlias(String alias) {

            }

            @Override
            public boolean isAlias(String beanName) {
                return false;
            }

            @Override
            public String[] getAliases(String name) {
                return new String[0];
            }
        };
        SimpleAliasRegistry simpleAliasRegistry=new SimpleAliasRegistry();
        SingletonBeanRegistry singletonBeanRegistry=new SingletonBeanRegistry() {
            @Override
            public void registerSingleton(String beanName, Object singletonObject) {

            }

            @Override
            public Object getSingleton(String beanName) {
                return null;
            }

            @Override
            public boolean containsSingleton(String beanName) {
                return false;
            }

            @Override
            public String[] getSingletonNames() {
                return new String[0];
            }

            @Override
            public int getSingletonCount() {
                return 0;
            }
        };
        BeanFactory beanFactory=new BeanFactory() {
            @Override
            public Object getBean(String name) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> requiredType) throws BeansException {
                return null;
            }

            @Override
            public Object getBean(String name, Object... args) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
                return null;
            }

            @Override
            public boolean containsBean(String name) {
                return false;
            }

            @Override
            public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String name, Class<?> targetType) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public String[] getAliases(String name) {
                return new String[0];
            }
        };
        DefaultSingletonBeanRegistry defaultSingletonBeanRegistry=new DefaultSingletonBeanRegistry();
        HierarchicalBeanFactory  hierarchicalBeanFactory=new HierarchicalBeanFactory() {
            @Override
            public BeanFactory getParentBeanFactory() {
                return null;
            }

            @Override
            public boolean containsLocalBean(String name) {
                return false;
            }

            @Override
            public Object getBean(String name) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> requiredType) throws BeansException {
                return null;
            }

            @Override
            public Object getBean(String name, Object... args) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
                return null;
            }

            @Override
            public boolean containsBean(String name) {
                return false;
            }

            @Override
            public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String name, Class<?> targetType) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public String[] getAliases(String name) {
                return new String[0];
            }
        };
        BeanDefinitionRegistry beanDefinitionRegistry=new BeanDefinitionRegistry() {
            @Override
            public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {

            }

            @Override
            public void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {

            }

            @Override
            public BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public boolean containsBeanDefinition(String beanName) {
                return false;
            }

            @Override
            public String[] getBeanDefinitionNames() {
                return new String[0];
            }

            @Override
            public int getBeanDefinitionCount() {
                return 0;
            }

            @Override
            public boolean isBeanNameInUse(String beanName) {
                return false;
            }

            @Override
            public void registerAlias(String name, String alias) {

            }

            @Override
            public void removeAlias(String alias) {

            }

            @Override
            public boolean isAlias(String beanName) {
                return false;
            }

            @Override
            public String[] getAliases(String name) {
                return new String[0];
            }
        };
        FactoryBeanRegistrySupport factoryBeanRegistrySupport=new FactoryBeanRegistrySupport() {
            @Override
            protected Class<?> getTypeForFactoryBean(FactoryBean<?> factoryBean) {
                return super.getTypeForFactoryBean(factoryBean);
            }
        };
    }
}
