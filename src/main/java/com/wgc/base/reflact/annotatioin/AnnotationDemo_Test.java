package com.wgc.base.reflact.annotatioin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author wgc
 * @Description
 * @Date 4/18/2020
 **/
public class AnnotationDemo_Test {

    @Field_Method_Parameter_Annotation(describe = "编号",type = int.class)
    int id;

    @Field_Method_Parameter_Annotation(describe = "姓名",type = String.class)
    String name;

    @Construction_Annotation
    public AnnotationDemo_Test(){

    }

    @Construction_Annotation("立即初始化构造方法")
    public AnnotationDemo_Test(@Field_Method_Parameter_Annotation(describe = "编号",type = int.class) int id,
                               @Field_Method_Parameter_Annotation(describe = "姓名",type = String.class) String name) {
        this.id = id;
        this.name = name;
    }

    @Field_Method_Parameter_Annotation(describe = "获取编号",type = int.class)
    public int getId() {
        return id;
    }

    @Field_Method_Parameter_Annotation(describe = "设置编号")
    public void setId(@Field_Method_Parameter_Annotation(describe = "编号",type = int.class) int id) {
        this.id = id;
    }

    @Field_Method_Parameter_Annotation(describe = "获得姓名",type = String.class)
    public String getName() {
        return name;
    }

    @Field_Method_Parameter_Annotation(describe = "设置姓名")
    public void setName(@Field_Method_Parameter_Annotation(describe = "姓名",type = String.class) String name) {
        this.name = name;
    }


    public static void main(String[] args) {

        /**
         *  Constructor,Field,Method都继承了AccessibleObject,所以它们都可以操作注解
         */
        AnnotationDemo_Test annotationDemoTestInstance = new AnnotationDemo_Test(26, "张三");
        Class annotationDemoClass = annotationDemoTestInstance.getClass();
        System.out.println("========构造方法注解测试==========");
        showConstructorAnnatation(annotationDemoClass);
        System.out.println();
        System.out.println("========成员变量注解解测试==========");
        showFieldAnnatation(annotationDemoClass);
        System.out.println();
        System.out.println("========成员方法注解解测试==========");
        showMethodAnnatation(annotationDemoClass);
    }

    private static void showMethodAnnatation(Class annotationDemoClass) {
        Method[] declaredMethods = annotationDemoClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            if(method.isAnnotationPresent(Field_Method_Parameter_Annotation.class)){
                Field_Method_Parameter_Annotation declaredAnnotation = method.getAnnotation(Field_Method_Parameter_Annotation.class);
                System.out.println("方法"+method.getName()+"的描述："+ declaredAnnotation.describe()+"; 方法的返回值类型："+declaredAnnotation.type());
            }else {
                continue;
            }

            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            //获取方法参数的注解
            for (int j = 0; j < parameterAnnotations.length; j++) {
                int length = parameterAnnotations[j].length;
                if(0 == length){
                    System.out.println("方法:"+method.getName()+"未添加注解");
                }else {
                    for (int k = 0; k < length; k++) {
                        Field_Method_Parameter_Annotation fAnnotation = (Field_Method_Parameter_Annotation) parameterAnnotations[j][k];
                        System.out.println("    参数描述："+fAnnotation.describe()+";参数类型:"+fAnnotation.type());
                    }
                }
            }
        }
    }

    private static void showConstructorAnnatation(Class clazz) {
        Class annotationDemoClass = clazz;
        //获取所有构造方法
        Constructor[] declaredConstructors = annotationDemoClass.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor constructor = declaredConstructors[i];
            //查看是否具有指定类型的注解
            if(constructor.isAnnotationPresent(Construction_Annotation.class)){
                //获取指定类型的注解
                Construction_Annotation annotationTemp = (Construction_Annotation)constructor.getAnnotation(Construction_Annotation.class);
                //获得注解信息
                System.out.println(annotationTemp.value());
            }

            //获得参数的注释
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++) {
                int length = parameterAnnotations[j].length;
                if(0 == length){
                    System.out.println("该参数未添加Annatation参数");
                }else {
                    for (int k = 0; k < length; k++) {
                        Field_Method_Parameter_Annotation filedAnnotation = (Field_Method_Parameter_Annotation) parameterAnnotations[j][k];
                        System.out.println("参数描述："+filedAnnotation.describe()+";参数类型："+filedAnnotation.type());
                    }
                }
            }
            System.out.println();
        }
    }

    private static void showFieldAnnatation(Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            if(field.isAnnotationPresent(Field_Method_Parameter_Annotation.class)){
                Field_Method_Parameter_Annotation fieldAnnotation = field.getAnnotation(Field_Method_Parameter_Annotation.class);
                System.out.println("字段的描述:"+fieldAnnotation.describe()+"; 字段的类型："+fieldAnnotation.type());
            }
        }
    }
}
