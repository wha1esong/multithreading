package com.chen.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexService {
    private String str;
//    @Autowired
//    UserService userService;

    public IndexService() {
        System.out.println("IndexService");
    }


    public void test() {
        System.out.println("IndexService test method");
    }

//    public UserService getUserService(){
//        return userService;
//    }
}
