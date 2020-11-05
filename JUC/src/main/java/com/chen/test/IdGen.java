package com.chen.test;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IdGen {
    public String generate() {
        StringBuilder generater = new StringBuilder();
        generater.append("110101");
        generater.append("20161110");
        generater.append(this.randomCode());
        generater.append(this.calcTrailingNumber(generater.toString().toCharArray()));
//        System.out.println("31023019920622745" +" and  "+calcTrailingNumber("31023019920622745".toCharArray()));
        return generater.toString();
    }

    public char calcTrailingNumber(char[] chars) {
        if (chars.length < 17) {
            return ' ';
        }
        int[] c = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] r = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int[] n = new int[17];
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(chars[i] + "");
        }
        for (int i = 0; i < n.length; i++) {
            result += c[i] * n[i];
        }
        return r[result % 11];
    }

    public String randomCode() {
        int code = (int) (Math.random() * 1000);
        if (code < 10) {
            return "00" + code;
        } else if (code < 100) {
            return "0" + code;
        } else {
            return "" + code;
        }
    }

    public static void writeFile(String str) throws IOException {
        BufferedWriter output = null;
        try {
            File f = new File("C:\\IDCard\\IDCard1.txt");
            output = new BufferedWriter(new FileWriter(f, true));

            output.write(str);
            output.write("\r\n");//换

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            output.flush();
            output.close();
        }
    }

    public static void main(String[] args) throws IOException {
        IdGen idGen = new IdGen();


        HashSet set = new HashSet();
        Iterator iterator = set.iterator();

        new Thread(() -> {
            while (set.size() < 100000) {
                String generate = idGen.generate();
                set.add(generate);
                System.out.println(generate);
            }
        }).start();


        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            idGen.writeFile(next);
        }


    }

}