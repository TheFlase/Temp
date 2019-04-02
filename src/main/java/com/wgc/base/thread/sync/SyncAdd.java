package com.wgc.base.thread.sync;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 1/6/2019
 **/
public class SyncAdd implements Runnable{
    private static int count = 0;
    private int shuzi;

    public SyncAdd(int shuzi) {
        this.shuzi = shuzi;
    }

    @Override
    public void run() {
        this.add(getShuzi());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SyncAdd(2),"t1");
        Thread t2 = new Thread(new SyncAdd(3),"t2");
        t1.start();
        t2.start();

    }

    private void add(int a) {
        this.count = this.count + a;
        int b = this.count;
        System.out.println(Thread.currentThread().getName()+"最终的结果是:"+ b);
    }

    public int getShuzi() {
        return shuzi;
    }

    public void setShuzi(int shuzi) {
        this.shuzi = shuzi;
    }
}
