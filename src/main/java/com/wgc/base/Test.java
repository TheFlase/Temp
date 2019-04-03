package com.wgc.base;

import java.io.SequenceInputStream;

/**
 * @author: wengguochao
 * @date: 2018/12/4 21:40
 * @desc:
 */

public class Test {
    public static void main2(String[] args) {
        String sql = "ALTER TABLE t_delivery_order_%03d ADD COLUMN user_def1 VARCHAR(60) NOT NULL DEFAULT '' COMMENT '货品自定义属性1(用于展示商品分类)' AFTER characteristic_show_value;";
        for(int i=0;i<256;i++){
            System.out.println(String.format(sql,i));
        }
    }

    public static void main(String[] args) {
        final int a = 9;
        final String b = "sdd";
        String c = "adsfa";
    }
}
