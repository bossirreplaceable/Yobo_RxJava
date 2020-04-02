package com.yobo.yobo_rxjava.test_head;

/**
 * Created by ZhangBoshi
 * on 2020-04-01
 */
public class Test_final{

    /**
     * 1、用 static 和 final 修饰的变量我们成为常量
     * 2、名称都要大写，并且用下划线连接word （命名规范）
     * 3、常量都必须要初始化赋值
     */
    public static final int CONSTANT=20;
    public static final String CONSTANT_STRING;

    /*
     * 4、静态初始化程序，它是一段加载类时会执行的一段代码，它会在其他类在使用它之前就执行，
     *    所以很适合放静态常量的初始化。
     */
    static {
        CONSTANT_STRING="必须初始化";
    }
}
