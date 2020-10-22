package com.wgc.designpattern.simglepattern;

import java.lang.reflect.Constructor;

/**
 * @Author wgc
 * @Description //静态内部类实现单例模式
 * 很多种单例的写法都有一个通病，就是无法防止反射机制的漏洞，从而无法保证对象的唯一性
 * @Date 2020/10/21
 **/
public class SimgleInnerPattern {
    private static SimgleInnerPattern instance;
    private SimgleInnerPattern(){}
    public SimgleInnerPattern getInstance(){
        return SimgleInnerHolder.innerInstance;
    }
    private static class SimgleInnerHolder{
        private static final SimgleInnerPattern innerInstance = new SimgleInnerPattern();
    }

    public static void main(String[] args) throws Exception{
        //获得构造器
        Constructor constructor = SimgleInnerPattern.class.getDeclaredConstructor();
        //设置为可访问
        constructor.setAccessible(true);
        SimgleInnerPattern instance1 = (SimgleInnerPattern) constructor.newInstance();
        SimgleInnerPattern instance2 = (SimgleInnerPattern) constructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance2.equals(instance1));

    }

}

