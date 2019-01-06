package com.wgc.base.thread.deadthread;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 1/4/2019
 **/
public class aaa {
    public static void main(String[] args) {
        try{
            int a = 3/0;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("============");
    }
}
