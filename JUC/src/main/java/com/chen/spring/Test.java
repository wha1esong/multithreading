package com.chen.spring;


import com.chen.app.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext();
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        System.out.println("-----------------");
//        for(String str:beanDefinitionNames){
//            System.out.println(str);
//        }
//        UserService bean = ac.getBean(UserService.class);
//        bean.test();
        ac.register(AppConfig.class);
        ac.refresh();
//        ((IndexService)ac.getBean("indexService")).test("1111");
        ((Activity)ac.getBean("userService")).start();
//         ac.getBean(IndexService.class).getUserService().test();
//        ((Test2)ac.getBean("indexService")).test();

//        Thread.sleep(10000);


//        Class<?> cls = Class.forName("com.chen.spring.IndexService");
//
//        Constructor c1 =cls.getDeclaredConstructor(String.class);
//
//        Object o = c1.newInstance("String");
//
//        System.out.println(o);

        ReentrantLock lock=new ReentrantLock();
    }
}
