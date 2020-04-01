package com.yobo.yobo_rxjava.test_head;

/**
 * Created by ZhangBoshi
 * on 2020-03-30
 */
public class Test_Object {

    static class Person {
        String name; // 实例变量的寿命与Person对象相同，如果该对象存活，该变量也会存活
    }

    public void showAge(int a) {
        int age = 23; // 局部变量只会存活在该方法调用的时候，当该方法执行完毕，那么该变量消失
        showName();
    }
    /**
     * 1、当showAge方法在调用ShowName方法的时候，showAge方法以及它的变量age都是存活的，只是不处于栈顶；
     * 2、这个时候的age变量是无法被使用的，只有在栈顶的showName函数中的name变量可以被使用；
     * 3、当这两个函数都执行完成之后，showAge函数和它的变量才会消失。
     */
    public void showName() {
        String name = "zhangSan";
        System.out.println("name");
    }

    public static void main(String[] args) {
        /**
         *  Perosn对象的生命周期取决于它的引用变量p，只要p一直引用着Person对象，那么该对象就会一直存活。
         */
        Person p=new Person();
    }
}
