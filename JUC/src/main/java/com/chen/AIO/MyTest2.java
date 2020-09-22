package com.chen.AIO;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest2 {
    public static AtomicInteger integer=new AtomicInteger();
    public static ConcurrentHashMap map=new ConcurrentHashMap();


    public static void main(String[] args) {
        File file = new File("C:"+File.separator+"IO"+File.separator);
        //读取目录下所有文件
        String[] filelist = file.list();

        for(int i=0 ;i <filelist.length-1;i++){
            Thread thread = new Thread(new Test01());
            thread.start();
        }

    }

    static class Test01 implements Runnable{
        @Override
        public void run() {
            int i=integer.getAndIncrement();
            File file = new File("C:"+File.separator+"IO"+File.separator);
            //读取目录下所有文件
            String[] filelist = file.list();
            if (filelist!=null){
                String s=filelist[integer.get()];
                System.out.println("解析第-----"+s+"------文件");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------------解析成功");
            map.put(i,"true");
        }
    }
}
