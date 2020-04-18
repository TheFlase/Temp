package com.wgc.base.reflact.method;

/**
 * @Author wgc
 * @Description
 * @Date 4/18/2020
 **/
public class Method_demo1 {
    static void staticMethod(){
        System.out.println("执行staticMethod()方法");
    }
    public int publicMethod(int i){
        System.out.println("执行publicMethod()方法");
        return i*5;
    }
    protected int protectedMethod(String s,int i)throws Exception{
        System.out.println("执行protectedMethod()方法");
        return Integer.valueOf(s)+i;
    }
    private String privateMethod(String...strings){
        System.out.println("执行privateMethod()方法");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }
}
