package com.chen.ThreadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BlockingQueue2<T> {


    ExecutorService service= (ThreadPoolExecutor)Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        
    }
    ExecutorService service2= Executors.newSingleThreadExecutor();
}
