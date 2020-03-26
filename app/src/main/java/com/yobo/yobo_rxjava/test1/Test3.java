package com.yobo.yobo_rxjava.test1;

/**
 * Created by ZhangBoshi
 * on 2020-03-25
 */
public class Test3 extends Object{

    abstract static class Animal {
        String name;
        abstract void bark();
    }
    abstract static class Dog extends Animal {
        abstract void bark();
        int age;
        public void sleep(){
            System.out.println("睡觉");
        }
    }


    public static void main(String[] args) {
//        Animal a = new Dog();
//        a.bark();
    }
}
