package com.yobo.yobo_rxjava.test_head;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ZhangBoshi
 * on 2020-04-07
 */
public class Test_Write_String {

    private static void testWrite() {
        String s = "我想要存储在本地my.txt文件中\n";
        try {
            // false参数可以每次清空my.txt文件内的内容，重新写入语句
            FileWriter writer = new FileWriter("my.txt", false);
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 1、BufferedWriter可以将我们要写入磁盘的文本先存储到BufferedWriter内部，缓存起来，当缓存空间占满之后，
     * 开始往本地磁盘写入，这样可以减少我们访问本地磁盘的次数，加快写入的效率。
     * 2、当然，如果我们向立即将BufferedWriter缓存内部的文本写入磁盘的话，可以使用 buffer.flush();
     */
    private static void testBufferWrite() {
        String s = "我先交由BufferedWriter存储，当它存满以后，把我写入到本地磁盘\n";
        String s1 = "我基础写入缓存中1\n";
        String s2 = "我基础写入缓存中2\n";
        String s3 = "我基础写入缓存中3\n";
        try {
            // true 可以在不删除前面内容的情况下，继续写入内容
            BufferedWriter buffer = new BufferedWriter(new FileWriter("my.txt", true));
            buffer.write(s);
            buffer.write(s1);
            buffer.write(s2);
            buffer.write(s3);
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 1、利用BufferedReader可以提高我们的读取效率，它只有在读取BufferedReader的缓存没有任何内容的时候，
     * 才会去读取磁盘。
     */
    private static void testReader() {
        try {

            File file = new File("my.txt");
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);

            String result;
            while ((result = buffer.readLine()) != null) {
                System.out.println("\n输出：" + result);
            }
            buffer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * File对象代表磁盘上的文件，或者目录的路径名称；
     * 它不能读取或者代表文件中的数据。
     */
    private static void testFile() {

        File dir = new File("test.txt");
        boolean isMk = dir.mkdir();
        System.out.println("mkdir=" + isMk);
        System.out.println("绝对目录=" + dir.getAbsolutePath());
        if (dir.isDirectory()) {
            String[] list = dir.list();
            for (String s : list) {
                System.out.println("目录：" + s);
            }
        }
    }

    public static void main(String[] args) {
        testWrite();
        testFile();
        testBufferWrite();
        testReader();
    }
}
