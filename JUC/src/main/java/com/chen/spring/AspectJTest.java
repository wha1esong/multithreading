package com.chen.spring;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJTest {

    @Pointcut("execution(* com.chen.spring.Activity.*(..))")
    public void anyActivity(){

    }

    @Before("anyActivity()")
    public void before(){
        System.out.println("aop-----------------");
    }

}
