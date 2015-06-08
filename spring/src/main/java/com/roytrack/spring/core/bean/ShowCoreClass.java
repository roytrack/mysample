package com.roytrack.spring.core.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.support.FactoryBeanRegistrySupport;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.AliasRegistry;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by roytrack on 2015/5/6.
 */
public class ShowCoreClass {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory );
        LongAdder a=new LongAdder();
        FileSystemXmlApplicationContext context=new FileSystemXmlApplicationContext();
        //BeanDefinitionParserDelegate
        ApplicationContext ac=new ApplicationContext() {
            @Override
            public String getId() {
                return null;
            }

            @Override
            public String getApplicationName() {
                return null;
            }

            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public long getStartupDate() {
                return 0;
            }

            @Override
            public ApplicationContext getParent() {
                return null;
            }

            @Override
            public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
                return null;
            }

            @Override
            public void publishEvent(ApplicationEvent event) {

            }

            @Override
            public BeanFactory getParentBeanFactory() {
                return null;
            }

            @Override
            public boolean containsLocalBean(String name) {
                return false;
            }

            @Override
            public boolean containsBeanDefinition(String beanName) {
                return false;
            }

            @Override
            public int getBeanDefinitionCount() {
                return 0;
            }

            @Override
            public String[] getBeanDefinitionNames() {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> type) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit) {
                return new String[0];
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
                return null;
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit) throws BeansException {
                return null;
            }

            @Override
            public String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType) {
                return new String[0];
            }

            @Override
            public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException {
                return null;
            }

            @Override
            public <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) throws NoSuchBeanDefinitionException {
                return null;
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

            @Override
            public Environment getEnvironment() {
                return null;
            }

            @Override
            public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
                return null;
            }

            @Override
            public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public Resource[] getResources(String locationPattern) throws IOException {
                return new Resource[0];
            }

            @Override
            public Resource getResource(String location) {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }
        };
        /***
         *  as of Spring 3.1 in favor of {@link DefaultListableBeanFactory} and
         * {@link XmlBeanDefinitionReader}
         *XmlBeanFactory f=new XmlBeanFactory();
         * */
        AliasRegistry c=new AliasRegistry() {
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
