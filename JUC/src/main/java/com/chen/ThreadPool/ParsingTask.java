package com.chen.ThreadPool;

import java.util.concurrent.Callable;

public class ParsingTask implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("ParsingTask-----------开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ParsingTask-----------结束");
        return "ok";
    }
}
