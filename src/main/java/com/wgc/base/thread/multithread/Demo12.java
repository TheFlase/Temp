package com.wgc.base.thread.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/12/2019
 **/
public class Demo12 {
    volatile boolean running = true;

    public void test() {
        System.out.println("test start.......");
        while (running) {
            /*try {
            TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }*/
            /**
             * 这段代码的目的是让CUP有空闲的时间,假如此次CPU去读主内存的running变量值,
             * 也可以实现线程间可见的效果，不过不推荐这样使用
             */
        }
        System.out.println("test end........");
    }

    public static void main(String[] args) {
        Demo12 demo12 = new Demo12();
        new Thread(demo12::test, "t1").start(); //JDK1.8新特性
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo12.running = false;
    }

    /**
     *  volatile 关键字，使一个变量在多个线程间可见
     *  A B线程都用到一个变量，java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道
     *  使用volatile关键字，会让所有线程都会读到变量的修改值
     *
     *  在下面的代码中，running是存在于堆内存的t对象中
     *  当线程t1开始运行的时候，会把running值从内存中读到t1线程的工作区，在运行过程中直接使用这个copy，并不会每次都去
     *  读取堆内存，这样，当主线程修改running的值之后，t1线程感知不到，所以不会停止运行
     *
     *  使用volatile，将会强制所有线程都去堆内存中读取running的值
     *
     *  可以阅读这篇文章进行更深入的理解
     *  http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
     * *
     */
}
