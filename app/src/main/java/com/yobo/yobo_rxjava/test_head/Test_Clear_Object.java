package com.yobo.yobo_rxjava.test_head;

/**
 * Created by ZhangBoshi
 * on 2020-03-30
 */
public class Test_Clear_Object {

    class Person {
        String name;
    }

    /**
     * 方式一：将对象的引用变量放在方法中，这样在方法执行完成之后，p1引用变量就会消失，
     *        这样对Person对象的引用就没有了，该对象就可以被GC回收了。
     */
    public void clear1(){
        Person p1=new Person();
    }

    /**
     * 方式二：引用被赋值到其他对象上，这样new的第一个Person对象就没有了引用，可以被回收。
     */
    public void clear2(){
        Person p2=new Person();
        p2=new Person();
    }
    /**
     * 方式三：直接将引用置空，这样Person对象就没被引用了。
     */
    public void clear3(){
        Person p3=new Person();
        p3=null;
    }
}
