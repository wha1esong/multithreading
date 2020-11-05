package com.chen.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements Activity{

    @Autowired
    IndexService indexService;

    public UserService(){
        System.out.println("UserService");
    }

    public void test(){
        System.out.println("UserService test method");
    }

    @Override
    public void start() {
        System.out.println("Activity");
    }
}
