package com.wgc.base.api;


import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 7/3/2018.
 */
public class JavaApiDemo {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>(1);
        List<String> list2 = new LinkedList<String>();
        list.add("aaa");

        list.add("aaa");
        System.out.println("+"+(1<<3));
        System.out.println(5/2);
        System.out.println(5>>1);
        list2.add("b");
        URLEncoder.encode("abc","utf8");
    }
}


