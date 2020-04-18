package com.wgc.base.reflact.annotatioin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author wgc
 * @Description 用于字段,方法和参数
 * @Date 4/18/2020
 **/
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Field_Method_Parameter_Annotation {
    String describe();
    Class type() default void.class;
}
