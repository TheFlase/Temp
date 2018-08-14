package com.wgc.base.api;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Queue;

/**
 * Created by Administrator on 7/11/2018.
 */
public class TempApi {
    public static void main(String[] args) throws Exception{
        int a=16;
        int c=-16;
        int b=2;
        Queue<Runnable> q = (Queue<Runnable>) new ArrayQueue<Runnable>(3);
//        int d=2;
//        System.out.println("4的二进制结果是："+Integer.toBinaryString(4));
//        System.out.println("a 的移位结果："+(a>>b));
//        System.out.println("-4的二进制结果是："+Integer.toBinaryString(-4));
//        System.out.println("c 的移位结果："+(c>>d));
        System.out.println(0xFFFF);
        Class<Per> p = Per.class;
        p.newInstance();
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

