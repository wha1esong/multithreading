package com.chen.spring;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MYInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy");
        return null;
    }
}
