package com.chen.ThreadPool;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private Deque<T> tDeque=new ArrayDeque<>();

    private int capacity;

    private ReentrantLock lock;

    private Condition fullWaitSet;

    private Condition emptyWaitSet;

    public BlockingQueue(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.capacity=capacity;
        lock=new ReentrantLock();
        fullWaitSet=lock.newCondition();
        emptyWaitSet=lock.newCondition();
    }

    public T poll(long time, TimeUnit unit) throws InterruptedException{
        long nanos=unit.toNanos(time);
        lock.lockInterruptibly();
        try{
            while (tDeque.isEmpty()){
                if (nanos<0)
                    return null;
               nanos= emptyWaitSet.awaitNanos(nanos);
            }
            return tDeque.removeFirst();
        }finally {
            lock.unlock();
        }
    }

    public void put(T e) throws InterruptedException{
        lock.lockInterruptibly();
        try{
            while (tDeque.size()==capacity){
                fullWaitSet.await();
            }
            tDeque.addLast(e);
        }finally {
            lock.unlock();
        }
    }
}
