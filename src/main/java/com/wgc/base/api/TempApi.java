package com.wgc.base.api;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * Created by Administrator on 7/11/2018.
 */
public class TempApi {
    public static void main1(String[] args) throws Exception{
        int a=16;
        int c=-16;
        int b=5;
        byte t = -128;

//        Queue<Runnable> q = (Queue<Runnable>) new ArrayQueue<Runnable>(3);
//        int d=2;
        System.out.println("4的二进制结果是："+Integer.toBinaryString(4));
        System.out.println("a 的移位结果："+(a>>b));
//        System.out.println("-4的二进制结果是："+Integer.toBinaryString(-4));
//        System.out.println("c 的移位结果："+(c>>d));
        System.out.println("19%6.7结果为:"+19%6);
        System.out.println(0xFFFF);
        System.out.println(-10.5%3);
        List<String> list =new ArrayList<String>();
        list.add("aa");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("a","aaa");
        Map<String,Object> map1 = new Hashtable<String, Object>();
        map1.put("a","aaa");
//        System.out.println("结果是！==="+(12==0xc?(0xc!=12?10:11):1));
        System.out.println("结果是！==="+0xc);
//        System.out.println("16进制转10进制"+Integer.parseInt("0X76",16));
        System.out.println(1<<4);

    }

    public static void main(String[] args) throws Exception{
        double a = 2;
        String b = "\\xF0\\x9F\\x98\\x85";
        System.out.println(a+3);
    }
}

abstract class Sang{
    protected abstract void sangZh();
    public void sang1(){
        System.out.println("sang1");
    }
}
class SangA extends Sang{
    @Override
    protected void sangZh() {

    }

    @Override
    public void sang1() {
        super.sang1();
    }
}

class Per{
    private int age;
    public Per(int age){
        this.age = age;
    }

}

