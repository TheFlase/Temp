package com.wgc.base.thread.multithread.reentrantlock;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 6/15/2019
 **/
public class ttt {
    public static void main(String[] args) {
        double a = 3.444;
        BigInteger b = new BigInteger("2342342342342342342342");
        Number c = 33;

        System.out.println(ttt.translate(a));
        System.out.println(ttt.translate(b));
        System.out.println(ttt.translate(c));

    }

    private static BigDecimal translate(Object obj){
        if(null == obj){
            return new BigDecimal("");
        }else {
            return new BigDecimal(String.valueOf(obj));
        }
    }
}
