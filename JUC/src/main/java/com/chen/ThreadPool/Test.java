package com.chen.ThreadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

@Component
public class Test {

    @Autowired
    private Test2 test2;

    ExecutorService service=new ThreadPoolExecutor(2,2,60L,TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
    @RequestMapping
    public void test() throws InterruptedException {
        ArrayList<Callable<Object>> list=new ArrayList<Callable<Object>>();

        for (int i = 0; i < 10; i++) {
           ParsingTask parsingTask=new ParsingTask();
           list.add(parsingTask);
        }
        service.invokeAll(list);

    }

}
