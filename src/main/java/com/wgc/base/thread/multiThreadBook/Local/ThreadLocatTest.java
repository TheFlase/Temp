package com.wgc.base.thread.multiThreadBook.Local;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/6/23
 **/
public class ThreadLocatTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("当前线程是:"+Thread.currentThread().getName()+"获取的值是:"
                    +ThreadLoaclTool.t1.get());
        }
        ThreadLocalB b = new ThreadLocalB();
        b.setName("b");
        b.start();
        ThreadLocalA a = new ThreadLocalA();
        a.setName("a");
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
