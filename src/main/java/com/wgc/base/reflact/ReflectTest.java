package com.wgc.base.reflact;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class ReflectTest implements Serializable{
	private static final long serialVersionUID = 3678982972206977014L;

	public static void main(String[] args) throws Exception {
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		c1 = Class.forName("com.wgc.base.reflact.ReflectTest");
		c2 = new ReflectTest().getClass();
		c3 = ReflectTest.class;
		
		//实例化class对象的3中方式
		System.out.println("class name is:"+c1.getName());
		System.out.println("class name is:"+c2.getName());
		System.out.println("class name is:"+c3.getName());
		
		//获取一个类的父类和实现接口
		Class<?> fatherClass = c1.getSuperclass();
		System.out.println("c1的父类是："+fatherClass.getName());
		Class<?> intes[] = c1.getInterfaces();
		System.out.println("c1类实现的接口有：");
		for(int i=0;i<intes.length;i++){
			System.out.println("第"+(i+1)+"个接口的接口名称是："+intes[i].getName());
		}
		
		//通过发射机制实现一个类的的对象
		Class<?> p1 = Class.forName("com.wgc.base.reflact.Person");
			//实例化默认构造方法,调用set赋值
		Person person = (Person) p1.newInstance();
		person.setAge(20);
		person.setName("wgc");
		System.out.println("默认构造方法是实例结果是："+person); // 结果 Person [age=20, name=wgc]
		
			//第二种方法 取得全部的构造函数 使用构造函数赋值
		Constructor<?>[] cons = p1.getConstructors();
		StringBuffer sBuffer = new StringBuffer();
		for(int i=0;i<cons.length;i++){
			Class<?> clazz[] = cons[i].getParameterTypes();
			sBuffer.append("cons[").append(i).append("](");
			for(int j=0;j<clazz.length;j++){
				if(j==clazz.length-1){
					sBuffer.append(clazz[j].getName());
				}else{
					sBuffer.append(clazz[j].getName()).append(",");
				}
			}
			sBuffer.append(")");
		}
		System.out.println("类的所有构造方法是："+sBuffer.toString());
		
		System.out.println("所有构造方法实例化开始：");
		person = (Person) cons[0].newInstance();
		System.out.println(person);
		person = (Person) cons[1].newInstance("wgc");
		System.out.println(person);
		person = (Person) cons[2].newInstance(21,"wgc2");
		System.out.println(person);
		System.out.println("所有构造方法实例化结束：");
		
	}

}
class Person{
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
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Person(){
		super();
	}
	public Person(String name){
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}
