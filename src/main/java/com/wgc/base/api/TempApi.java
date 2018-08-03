package com.wgc.base.api;

/**
 * Created by Administrator on 7/11/2018.
 */
public class TempApi {
    public static void main(String[] args) throws Exception{
        int a=16;
        int c=-16;
        int b=2;
        int d=2;
        System.out.println("4的二进制结果是："+Integer.toBinaryString(4));
        System.out.println("a 的移位结果："+(a>>b));
        System.out.println("-4的二进制结果是："+Integer.toBinaryString(-4));
        System.out.println("c 的移位结果："+(c>>d));
    }
}

