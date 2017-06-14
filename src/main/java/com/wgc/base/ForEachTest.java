package com.wgc.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ForEachTest {

	public static void main(String[] args) {
		/**
		 * 产生一个50至100的随机数作为List的容量，然后每次遍历10条数据打印出来
		 * 
		 */
		
		int count = (int) (Math.random()*50+50);
		System.out.println("产生的随机数大小是："+count);
		List<String> list = new ArrayList<String>();
		for(int i=0;i<count;i++){
			list.add(i+"");
		}
		//求出遍历的次数
		int time = count/10==0?count/10:count/10+1;
		System.out.println("需要打印的次数是："+time+"次！");
		for(int i=0;i<time;i++){
			int timeCount = 10;//每次的数量为10
			System.out.println("第"+(i+1)+"次打印开始=》");
			for(int j=i*timeCount;j<i*timeCount+10;j++){
				System.out.println(list.get(j));
				if(j==list.size()-1){
					break;
				}
			}
			System.out.println("第"+(i+1)+"次打印结束！");
		}
		
		
	}

}
