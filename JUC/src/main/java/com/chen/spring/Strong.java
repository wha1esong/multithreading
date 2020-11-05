package com.chen.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

//@Component
public class Strong implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        if(beanName.equals("indexService")){
            System.out.println("indexService 实例化之前");
//            return Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{Test2.class},new MYInvocationHandler());
        }

        return null;
    }


    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("indexService"))
            System.out.println("postProcessAfterInstantiation----"+beanName);
        return true;
    }
}
