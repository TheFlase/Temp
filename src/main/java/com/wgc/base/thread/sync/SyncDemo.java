package com.wgc.base.thread.sync;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 1/6/2019
 **/
public class SyncDemo extends Thread{
    private int count = 0;
    Object lock = new Object();

    @Override
    public void run() {
        synchronized (this){
            for (int j = 0; j < 3; j++) {
                count++;
                System.out.println("threadname:"+this.currentThread().getName()+"\t"+"count="+count);
            }
        }
    }

    private synchronized void add1(){
        for (int j = 0; j < 3; j++) {
            count++;
        }
        System.out.println("after add1 caculate this result is:"+count);
    }

    private void add2(){
        synchronized (lock){
            for (int j = 0; j < 3; j++) {
                count++;
            }
        }
        System.out.println("after add2 caculate this result is:"+count);
    }

    private void add3(){
        synchronized (this){
            for (int j = 0; j < 3; j++) {
                count++;
            }
        }
        System.out.println("after add3 caculate this result is:"+count);
    }

    public static void main(String[] args) throws Exception{
        SyncDemo syncDemo1 = new SyncDemo();
        SyncDemo syncDemo2 = new SyncDemo();
        Thread t1 = new Thread(syncDemo1,"demo1");
        Thread t2 = new Thread(syncDemo2,"demo2");
        t1.start();
        t2.start();

    }
}
