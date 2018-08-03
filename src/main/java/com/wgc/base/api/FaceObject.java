package com.wgc.base.api;


/**
 * Created by Administrator on 7/9/2018.
 */
public class FaceObject {
    public static void main(String[] args) {
        Integer[] data = fun(1, 2, 3, 4, 5);
        for (int i : data) {
            System.out.println(i);
        }
    }

    //<T>描述的是泛型标记的声明
    public static <T> T[] fun(T... args) {
        return args;
    }
}

