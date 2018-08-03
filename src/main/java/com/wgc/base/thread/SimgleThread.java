package com.wgc.base.thread;

/**
 * Created by Administrator on 3/31/2018.
 */
public class SimgleThread extends Thread{

    private int count = 5;

    @Override
    public void run() {
        count--;
        System.out.println("threadname:"+this.currentThread().getName()+"\t"+"count="+count);
    }

    public static void main(String[] args) {
        SimgleThread simgleThread = new SimgleThread();
        Thread t1 = new Thread(simgleThread,"t1");
        Thread t2 = new Thread(simgleThread,"t2");
        Thread t3 = new Thread(simgleThread,"t3");
        Thread t4 = new Thread(simgleThread,"t4");
        Thread t5 = new Thread(simgleThread,"t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        /**
         * 运行结果有这些
         * threadname:t1	count=4
         threadname:t2	count=3
         threadname:t3	count=2
         threadname:t5	count=0
         threadname:t4	count=0
         *
         */

    }
}
