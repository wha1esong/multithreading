package com.chen.ThreadPool;


import org.springframework.stereotype.Component;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Component
public class Test2 {

    private static ExecutorService service;
    public Test2(){
        service=new ThreadPoolExecutor(2,2,60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
    }
    public void test(){

    }
}
