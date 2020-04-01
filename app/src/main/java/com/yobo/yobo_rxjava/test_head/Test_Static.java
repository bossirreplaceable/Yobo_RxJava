package com.yobo.yobo_rxjava.test_head;

/**
 * Created by ZhangBoshi
 * on 2020-03-31
 */
public class Test_Static {

    public String name; //实例变量 每new一个对象就会创建一个新的name变量

    /**
     * 1、如果你new 了好多个Test_Static实例，但是静态变量age只会有一个，所有的实例共享这一个age，
     *    你在某处改变age的值，其他所有实例的age值也会改变。
     */
    public static int age=2;

    /**
     * 2、静态变量只会在类第一次载入的时候被初始化。类会被加载是因为Java虚拟机认为它该被加载，
     *    通常，Java虚拟机会加载某个类是因为第一次有人要尝试创建该类的新实例，或是使用该类的
     *    静态方法或变量。
     * 3、静态变量会在该类的任何对象创建之前就完成初始化；
     * 4、静态变量会在该类的任何静态方法执行之前就初始化完成。
     */
    public static String sex;
    /**
     * 5、静态的main方法，无法调用非静态变量name，因为它们不知道堆上有哪些实例。
     */
    public static void main(String[] args) {

    }
}
