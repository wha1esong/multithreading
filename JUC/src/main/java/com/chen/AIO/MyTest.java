package com.chen.AIO;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {
    public static AtomicInteger integer=new AtomicInteger();

    public static void main(String[] args) throws Exception {
        integer.getAndIncrement();
//        Test01 t01=new Test01();
//        Test01 t02=new Test01();
//        Thread t1 = new Thread(t01);
//        Thread t2 = new Thread(t02);
//        t1.start();
//        t2.start();

        File file = new File("C:"+File.separator+"IO"+File.separator);
        //读取目录下所有文件
        String[] filelist = file.list();

        System.out.println(filelist);

    }
    static class Test01 implements Runnable{
        @Override
        public void run() {
            integer.getAndIncrement();
            String path="C:"+File.separator+"IO"+File.separator+"IO.txt";
            String outPath="C:"+File.separator+"IO"+File.separator+"OUT.txt";
            BufferedInputStream in=null;
            BufferedOutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(path));
                out = new BufferedOutputStream(new FileOutputStream(outPath));

                byte[] b = new byte[1024];
                int len = -1;
                while ((len = in.read(b, 0, b.length)) != -1) {
                    String str = new String(b, 0, len, "UTF-8");
                    System.out.println(str);
                    out.write(b, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    //刷新缓冲
                    out.flush();
                    //关闭流对象
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
