package com.wangwang.test;

import java.util.Date;

public class TestParameter {
	public static void test(String[] args) {
		
	}
	//可变参数
	public static void test2(String... args) {
		System.out.println(args.length);
		for (String string : args) {
			System.out.println(string);
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		int a = 10;
		Integer b = a;
		int c = b;
			
	}
	//jd
	public static void main(String[] args) {
		TestParameter.test2();
		TestParameter.test2("aaa", "bbbb");
		String[] ggg = {"gggg", "gggggggg"};
		TestParameter.test2(ggg);
		System.out.println(new Date());
		
	}
}
