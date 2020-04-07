package com.yobo.yobo_rxjava.test_head;

import java.io.IOException;

/**
 * Created by ZhangBoshi
 * on 2020-04-03
 */
public class Test_Exception {

    public static void main(String[] args) {
        testTry();
    }

    /**
     * 1、对于非检查异常，我们不加try catch 块也不会报错
     * 2、但是，如果我们不处理异常，程序运行时将直接奔溃
     * 3、在try catch模块中我们可以尝试修复异常，
     */
    private static void testTry() {
        try {
            testException();
            System.out.println("发生异常后，会立马转到catch模块，所以我是不会被打印的");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            //尝试修复异常····
            e.printStackTrace(); // 如果无法恢复异常，我们至少应该打印异常信息
        }finally {
            System.out.println("不管有没有return，我都会执行");    // 不管try 或者catch块中有没有return 语句，这里都会执行
        }
        System.out.println("处理异常后，我还能运行！");    //因为我们处理了异常，所以往后的程序还能继续运行
        testTry1();
    }

    private static void testTry1() {
        testException();
        System.out.println("不处理异常，我无法运行！");     //到这里之前程序就奔溃了，所以这行不会打印出来
    }


    /**
     * 非检查异常：我们可以不声明抛出的异常
     */
    private static void testException() {
        throw new ArrayIndexOutOfBoundsException("指针越界了！");
    }

    /**
     * 1、对于检查异常，调用方必须处理该异常
     * 2、处理方式一：加try 块
     * 3、处理方式二：继续抛出异常,让更上一层调用方处理
     */
    private static void testTry2() throws IOException{
        testIOException();
    }

    /**
     * 检查异常：1、我们必须声明一下它可能抛出异常（throws IOException ）
     *          2、该异常也一定会抛给调用方
     */
    private static void testIOException() throws IOException {
        throw new IOException ("IO出问题了！");
    }


}
