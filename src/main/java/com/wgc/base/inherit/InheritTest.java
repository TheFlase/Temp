package com.wgc.base.inherit;

/**
 * Created by Administrator on 7/1/2018.
 */
public class InheritTest {
    public static void main(String[] args) {
        Cat cat = new Cat(new SayBody());
//        Dog dog =
    }
}
class Animal{

}
class Dog extends Animal{

}
class Cat extends Animal implements Action{
    private Action action;
    public Cat(Action ac){
        this.action = ac;
    }

    @Override
    public String say() {
        return "say a world!";
    }
}
interface Action{
    public String say();
}

class SayBody implements Action{
    @Override
    public String say() {
        return "我才是真正的说话的人";
    }
}
