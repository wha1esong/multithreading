package com.chen.spring;


import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName： ImportData
 * @description: 导入1亿sql
 * @author: 李胜
 * @create: 2020-11-04 07:51
 **/
public class Test4 {
    static class Data {
        private int data;


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }


    }

    static ArrayBlockingQueue<String> data = new ArrayBlockingQueue<>(4 * 1024 * 1024 / 100);

    public static String getMydata() {

        return data.peek();
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024));
        threadPoolExecutor.execute(() -> {
            File file = new File("/Users/lisheng/Downloads/sql");
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String dataStr = bufferedReader.readLine();
                    data.put(dataStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ThreadPoolExecutor retryPoolExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024));
        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(() -> {
                while (true) {
                    String mydata = getMydata();
                    boolean b = importBoolean(mydata);
                    if (!b) {
                        retryPoolExecutor.execute(() -> {
                            int maxRetry = 10;
                            while (maxRetry > 0) {
                                boolean isSuccess = importBoolean(mydata);
                                if (!isSuccess) {
                                    maxRetry--;
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }

    }

    public static boolean importBoolean(String data) {
        return true;
    }
}
