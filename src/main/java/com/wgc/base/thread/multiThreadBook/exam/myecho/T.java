package com.wgc.base.thread.multiThreadBook.exam.myecho;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/9/3
 **/
public class T {
    public static int index = 1;
    public static void main(String[] args) {
        T t = new T();
        try {
            t.call();
        } catch (Throwable e) {
            System.out.println("statck deep:"+ index);
            e.printStackTrace();
        }
    }
    public void call(){
        index++;
        call();
    }

}
