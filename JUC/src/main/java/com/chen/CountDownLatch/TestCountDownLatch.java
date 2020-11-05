package com.chen.CountDownLatch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(10);
        ExecutorService executor= Executors.newFixedThreadPool(10);
        String[] str=new String[10];
        Random r=new Random();


        for (int j = 0; j <10 ; j++) {
            int k=j;
            executor.submit(()->{
                for (int i = 0; i <=100 ; i++) {
                    try {
                        Thread.sleep(r.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    str[k]=i+"%";
                    System.out.print("\r"+Arrays.toString(str));
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("\n----------------------Game Start-----------------------");
        executor.shutdown();


    }
}
