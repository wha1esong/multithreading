package com.chen.yuewen;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2020/12/21 10:11 上午
 */
public class Test4 {

	public static void main(String[] args) {
//		System.out.println("abc".matches("^(?!.*(abc)).*$"));
//		System.out.println("cvs".matches("^(?!.*(svn|cvs|nvs|mvc)).*$"));
//		System.out.println("java-cvsproxy".matches("^[-a-zA-Z0-9]+$"));
//		System.out.println("172.168.".matches("^[-.a-zA-Z0-9]+$"));


		String s="com.huixian.axUser.dubbo.facade.api.DubboAppleUserServiceV2";
		System.out.println(s.matches("^[-_.:a-zA-Z0-9]+$"));
	}
}
