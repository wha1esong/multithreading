package com.chen.spring;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test6 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/Users/erebus/IO/test2.txt")));
        for (int i = 0; i < 10000000; i++) {
            bufferedWriter.write(String.valueOf(i));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            Thread.sleep(100);
        }

//        bufferedWriter.close();
    }
}
