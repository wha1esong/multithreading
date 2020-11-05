package com.chen.AIO;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest2 {
    public static AtomicInteger integer=new AtomicInteger();
    public static ConcurrentHashMap map=new ConcurrentHashMap();


    public static void main(String[] args) throws Exception{
        File file = new File("C:"+File.separator+"IO"+File.separator);
        //读取目录下所有文件
        String[] filelist = file.list();

//        for(int i=0 ;i <filelist.length-1;i++){
//            Thread.sleep(100);
//            Thread thread = new Thread(new Test01());
//            thread.start();
//        }

        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(6);
        for (int i=0 ;i <=filelist.length-1;i++) {
            cachedThreadPool.execute(new Test01(integer.getAndIncrement()));
        }
        cachedThreadPool.shutdown();
    }

    static class Test01 implements Runnable{
        private int index=0;
        public Test01(int index){
            this.index=index;
        }
        @Override
        public void run() {
            File file = new File("C:"+File.separator+"IO"+File.separator);
            String s="";
            //读取目录下所有文件
            String[] filelist = file.list();
            if (filelist!=null){
                 s=filelist[index];
                System.out.println("解析第-----"+s+"------文件");
            }
            String path="C:"+File.separator+"IO"+File.separator+s;
            String outPath="C:"+File.separator+"IO"+File.separator+index+".txt";
            BufferedInputStream in=null;
            BufferedOutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(path));
                out = new BufferedOutputStream(new FileOutputStream(outPath));

                byte[] b = new byte[4];
                int len = -1;
                while ((len = in.read(b, 0, b.length)) != -1) {
                    String str = new String(b, 0, len, "UTF-8");
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
            System.out.println(""+s+"---------------解析成功");
            map.put(index,"true");
        }
    }
}
