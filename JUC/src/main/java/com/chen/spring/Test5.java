package com.chen.spring;

import sun.awt.windows.ThemeReader;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test5 {


    public static void main(String[] args) throws Exception {
        File file = new File("/Users/erebus/IO/test2.txt");
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new FileReader(file));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024));
        ThreadPoolExecutor retryPoolExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024));
        ThreadPoolExecutor wirteExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/Users/erebus/IO/test2.txt")));


        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Parse(bufferedReader, retryPoolExecutor));
        }
        for (int i = 0; i < 1; i++) {
            wirteExecutor.execute(new writeSql(bufferedWriter));
        }


//        Parse p1 = new Parse(bufferedReader, retryPoolExecutor);
//        Parse p2 = new Parse(bufferedReader, retryPoolExecutor);
//        new Thread(p1).start();
//        new Thread(p2).start();

    }

    static class writeSql implements Runnable {
    private BufferedWriter bw;

        public writeSql(BufferedWriter bw) {
            this.bw = bw;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                try {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Parse implements Runnable {
        private BufferedReader br;
        private ThreadPoolExecutor tp;

        public Parse(BufferedReader br, ThreadPoolExecutor tp) {
            this.tp = tp;
            this.br = br;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String s = br.readLine();
                    while (s != null) {
                        Boolean b = importData(s);
                        if (!b || s.equals("D")) {
                            tp.execute(new RetryParse(s));
                        }
                        s = br.readLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class RetryParse implements Runnable {
        private String s;
        private int retryTime;

        public RetryParse(String s) {
            this.s = s;
            retryTime = 10;
        }

        @Override
        public void run() {
            while (retryTime > 0) {
                boolean isSuccess = importData(s);
                if (!isSuccess || s.equals("D")) {
                    retryTime--;
                    try {
                        System.out.println(Thread.currentThread() + "当前重试次数第： " + retryTime + " 次");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean importData(String s) {
        System.out.println(Thread.currentThread() + s);
        return true;
    }
}
