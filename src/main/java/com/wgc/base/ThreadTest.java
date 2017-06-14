package com.wgc.base;

public class ThreadTest implements Runnable{
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			ThreadTest t1 = new ThreadTest();
			t1.run();
		}
	}
	
	public synchronized static void printValue(){
		int i=0;
		i++;
		System.out.println(i);
	}

	@Override
	public void run() {
		printValue();
	} 
}
