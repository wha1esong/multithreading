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

    public int A()  {
        try {
            System.out.println("进入try");
            return -1;
        } catch (Exception e) {

        } finally {
            System.out.println("执行了finally");
        }
        int a = 2;
        return a;
    }

    public void test() {
        System.out.println("IndexService test method");
    }

//    public UserService getUserService(){
//        return userService;
//    }
}
