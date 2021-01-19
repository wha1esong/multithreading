package com.chen.yuewen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2020/12/25 4:59 下午
 */
public class Test7 {

	private Lock lock;

	public Test7() {
		lock = new ReentrantLock();
	}

	public Integer test() {
		if (lock.tryLock()) {
			System.out.println(Thread.currentThread());
		} else {
			return -1;
		}

		return 1;
	}

}
