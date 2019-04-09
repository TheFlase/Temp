package com.wgc.base.thread.multithread;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/10/2019
 **/
public class Demo06 implements Runnable {
    private int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Demo06 demo06 = new Demo06();//注意这里
            new Thread(demo06, "THREAD" + i).start();
        }
    }

    /**
     * 1.执行可以知道，demo中虽然加上了synchronized关键字来修饰方法，但是线程是不安全的。为什么呢？？
     * 分析一下：synchronized修饰的是普通方法，锁定的是Demo06实例，从Main方法中可以看到，在for循环中
     * 创建了多个Demo06的实例，也就是说每个线程对应都拿到各自的锁标记，可以同时执行。
     * 例子：
     * 多人同时上厕所，厕所门只有一把锁的时候是一个人上完之后把钥匙(锁标记)给到下一个人才可以开门上厕所
     * 如果厕所门的锁有多个钥匙的情况下，就是每个人都有锁的钥匙了，大家可以一起去打开门来上厕所。(归根结底还是堆内存上的地址)
     * demo中就如同厕所门的锁有多把钥匙(锁标记)，不能实现线程安全
     */
}
