package com.chen.yuewen;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2020/12/18 9:34 上午
 */
public class Test3 {



	public static void main(String[] args) {
		Integer atomicInteger = 0;
		test(atomicInteger);
		test(atomicInteger);
		System.out.println(atomicInteger);
	}

	public static void test(Integer a) {
		a=a+100;
	}

}
