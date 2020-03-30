package com.yobo.yobo_rxjava.test2;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by ZhangBoshi
 * on 2020-03-30
 */
public class Test_Subject {

    //成员变量
    private String  hello;  //存储于堆中

    //成员变量
    private Person  per=new Person();   //per是对Person对象的引用，存储于堆中，new出来的Person对象也存储于堆中

   static class  Person{
        //实例变量
        String name;  //name存储在堆中

       public void setName(String name) {
           this.name = name;
       }

       public String getName() {
           return name;
       }
   }

    public void showAge(int a){   //参数a也是局部变量 存储于栈中

        //局部变量
        int age=23;               //age存储在栈中
        //p也是局部变量
        Person p=new Person();    //p存储在栈， new Person（)这个对象存储在堆中
    }


    private final PublishSubject<String> subject=PublishSubject.create();


    public static void main(String[] args) {

        System.out.println(new Person().getName());
    }



}
