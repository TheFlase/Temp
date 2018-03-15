package com.wgc.base.compare;

/**
 * Created by Administrator on 3/14/2018.
 */
public class Person implements Comparable<Person>{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int compareTo(Person p1) {
        if(this.getAge()-p1.getAge() == 0) {
            return this.getName().compareTo(p1.getName());
        }else {
            return this.getAge()-p1.getAge();
        }
    }
}
