package com.chen.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.bytecode.analysis.Executor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


//        Executors.newFixedThreadPool()
        HashMap map=new HashMap();
        map.put("","");
        LockSupport.park();



    }
}
