package com.chen.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.chen.AIO.AIOServer");
        ClassLoader classLoader = aClass.getClassLoader();
        classLoader.loadClass("com.chen.AIO.AIOServer");

    }
}
