package com.wgc.base.api;

public class ThreadTest {

}

class Person implements Runnable{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void run(){
        methodOne();
    }

    public void methodOne(){
        int localVariable1 = 45;

        MySharedObject localVariable2 =
                MySharedObject.sharedInstance;

        // ...使用局部变量做更多事情。

        methodTwo();
    }

    public void methodTwo(){
        Integer localVariable1 = new Integer(99);

        // ...使用局部变量做更多事情。
    }

}

class MySharedObject{
    //指向MySharedObject实例的静态变量

    public static final MySharedObject sharedInstance = new MySharedObject();


    //成员变量指向堆上的两个对象

    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    public long member1 = 12345;
    public long member2 = 67890;
}