package com.chen.spring;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile rf = new RandomAccessFile(new File("/Users/erebus/IO/test.txt"), "rw");

        new Thread(() -> {
            try {
                for (int i = 0; i < 7; i++) {
                    String s = rf.readLine();
                    System.out.println(Thread.currentThread() + String.valueOf(System.currentTimeMillis()) + s);
                    System.out.println(Thread.currentThread() + String.valueOf(System.currentTimeMillis()) + String.valueOf(rf.getFilePointer()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 7; i++) {
                    String s = rf.readLine();
                    System.out.println(Thread.currentThread() + String.valueOf(System.currentTimeMillis()) + s);
                    System.out.println(Thread.currentThread() + String.valueOf(System.currentTimeMillis()) + String.valueOf(rf.getFilePointer()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
