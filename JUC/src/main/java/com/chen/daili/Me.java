package com.chen.daili;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

public class Me {
    public static void main(String[] args) {
        Girl girl=new lizhiqing();
        GirlHandler proxyGirl = new GirlHandler(girl);
        Girl lizhiqing = (Girl)Proxy.newProxyInstance(Me.class.getClassLoader(), new Class[]{Girl.class}, proxyGirl);
        lizhiqing.playGame();

    }
}
