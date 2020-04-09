package com.yobo.yobo_rxjava.test_head;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangBoshi
 * on 2020-04-08
 */
public class Test_Wan {

    class Animal {
        String name;
        public void eat() {
            System.out.println("吃饭");
        }
    }
    class Dog extends Animal {
        int age;
    }
    class Pig extends Animal {
        int age;
    }

    /**
     * 1、在方法参数中使用万用字符，编译器会阻止任何可能破坏引用参数所指集合的行为；
     * 2、但是可以强转后进行改变集合，但是这样就失去了这样设计的意义
     */
    private void test(ArrayList<? extends Animal> list) {
//        list.add(new Dog());

        ArrayList<Dog> dogs= (ArrayList<Dog>) list;
        dogs.add(new Dog());
        for (Animal animal : list) {
            animal.eat();
        }
    }

    /**
     * 万能字符？ 可以让我们的test方法接受任何 Animal子类的的list
     */
    private void m() {

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        test(dogs);
        // ---------------------------
        ArrayList<Pig> pigs = new ArrayList<>();
        pigs.add(new Pig());
        test(pigs);
    }

    /**
     * 如果你的两个参数都是接受Animal的子类的集合，可以使用下面的方式书写
     */
    private void test1(ArrayList<? extends Animal> list,ArrayList<? extends Animal> list1) {

    }
    private <T extends Animal> void test2(ArrayList<T> list,ArrayList<T> list1) {

        String a="0";
        for (int i=1;i<10;i++){
            a=a+i;
        }
    }

}
