package com.chen.ThreadPool;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    //任务队列
    private BlockingQueue<Runnable> taskQueue;
    //线程集合
    private HashSet<Worker> workers;


    private int coreSize;

    private long time;

    private TimeUnit unit;



    public ThreadPool(int coreSize,long time,TimeUnit unit,int capacity){
        this.coreSize=coreSize;
        this.time=time;
        this.unit=unit;
        this.taskQueue=new BlockingQueue<>(capacity);
    }

    class Worker extends Thread{

    }

    public void execute(Runnable task){
        if (workers.size()<coreSize){

        }
    }
}
