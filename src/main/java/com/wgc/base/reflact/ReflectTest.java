package com.wgc.base.reflact;

import java.lang.reflect.Method;

public class ReflectTest {
	public static void main(String[] args) throws Exception {
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		c1 = Class.forName("base.ReflectTest");
		c2 = new ReflectTest().getClass();
		c3 = ReflectTest.class;
		System.out.println("class name is:"+c1.getName());
		System.out.println("class name is:"+c2.getName());
		System.out.println("class name is:"+c3.getName());
		
		
	}

}
