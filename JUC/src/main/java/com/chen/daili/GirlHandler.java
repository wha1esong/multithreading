package com.chen.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GirlHandler implements InvocationHandler {
    private Girl girl;
    public GirlHandler(Girl girl){
        this.girl=girl;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(girl, null);
        after();
        return null;
    }
    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }


}
