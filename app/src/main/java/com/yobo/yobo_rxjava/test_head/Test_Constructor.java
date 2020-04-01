package com.yobo.yobo_rxjava.test_head;

/**
 * Created by ZhangBoshi
 * on 2020-03-31
 */
public class Test_Constructor {

    static class Animal{
        public String name;
        public final int age=1;
        public Animal() {
            System.out.println("你好");
        }
    }

    static class  Dog extends Animal{
        public Dog() {
            System.out.println("汪汪");
        }
        public Dog(String name) {
            System.out.println("汪汪");
        }
    }

    public static void main(String[] args) {
        Dog a=new Dog();
        Dog b=new Dog("小花");
    }
}
