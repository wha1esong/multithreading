package com.chen.spring;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class Test3 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile rf = new RandomAccessFile(new File("/Users/erebus/IO/test.txt"), "rw");
        Parse p1 = new Parse(rf);
        Parse p2 = new Parse(rf);

        FutureTask<Integer> ft1 = new FutureTask(p1);
        FutureTask<Integer> ft2 = new FutureTask(p2);
        new Thread(ft2).start();
        new Thread(ft1).start();

        Integer o = ft1.get();
        Integer o1 = ft2.get();
        System.out.println(Math.max(o, o1));
        System.out.println((int) o);
        System.out.println((int) o1);

    }

    static class Parse implements Callable {
        private RandomAccessFile rf;
        private int maxSize;

        public Parse(RandomAccessFile rf) {
            this.rf = rf;
        }

        @Override
        public Object call() throws IOException {
            for (int i = 0; i < 3; i++) {
                String s = null;
                try {
                    s = rf.readLine();
                    String[] split = s.split(":");
                    int s1 = Integer.valueOf(split[1]);
                    maxSize = Math.max(s1, maxSize);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return maxSize;
        }


    }

}
