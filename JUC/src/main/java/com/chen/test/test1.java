package com.chen.test;

import java.lang.reflect.Field;

class Node {
    private int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class test1 {
    public static void main(String[] args) throws Exception {

        Node n=new Node(1);
        Class cls=n.getClass();

//        Field[] declaredFields = cls.getDeclaredFields();
//        Stream<Field> stream = Arrays.stream(declaredFields);
//        stream.forEach(System.out::println);

        Field field = cls.getDeclaredField("val");
        field.setAccessible(true);
        Object o = field.get(n);
        field.set(n,2);

        System.out.println(o);



    }
}
