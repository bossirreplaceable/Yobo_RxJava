package com.yobo.yobo_rxjava.test_head;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by ZhangBoshi
 * on 2020-04-03
 */
public class Test_Serializable {

    static class Student implements Serializable {

        static final long serialVersionUID=23333;

        String name;
        int age;
        /**
         * 1、Student内所有类对象都应该可以被序列化，否则Student将序列化失败，并报错。
         * 2、如果两个Student对象中对Person的引用指向同一个对象，那么这个Person只会被存储
         *    一次，另一个Student被复原以后，会拥有该对象的指向。
         */
        Person p = new Person();
        /**
         * 1、当然如果你不需要对该对象进行序列化的话，可以用transient标记，这样即使Teacher
         *    没有实现Serializable接口，Student也能序列化成功。
         */
        transient Teacher t=new Teacher();

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    /**
     * 1、因为Student持有对Person对象的引用，所以Person类也必须实现Serializable接口，否则
     *    Student对象将会序列化失败。
     */
    static class Person implements Serializable{
        String name;
    }
    static class Teacher {
        String name;
    }
    /**
     * 1、FileOutputStream是写入字节的方法，所以我们需要先把我们的对象转换成字节，
     *   ObjectOutputStream就是将我们的对象转换成可以写入的串流数据。
     */
    private static void testWrite() throws IOException {

        Student s = new Student("张三", 22);
        Student s1 = new Student("李四", 12);
        // 创建存取文件的FileOutputStream对象
        FileOutputStream fileStream = new FileOutputStream("Student.ser");
        // 创建写入对象的ObjectOutputStream对象
        ObjectOutputStream os = new ObjectOutputStream(fileStream);
        os.writeObject(s);
        os.writeObject(s1);
        os.close();
    }

    /**
     * 解序列化过程：
     * 1、对象从stream流中读取出来；
     * 2、Java虚拟机通过存储信息判断出对象的class类型；
     * 3、Java虚拟机尝试寻找和加载对象的类。如果Java虚拟机找不到或无法加载该类，
     *    则Java虚拟机会抛出异常ClassNotFoundException；
     * 4、新的对象会被配置在堆上，但是构造函数不会被执行！执行会抹除我们对象的信息。
     * 5、如果对象在继承树上有一个不可序列化的祖先类，则该不可序列化类以及在它之上
     *    的类的构造函数（就算是可序列化也会执行）就会执行。一旦构造函数连锁启动之后
     *    将无法停止。也就是说，从第一个不可序列化的父类开始，全部都会重新初始状态。
     * 6、对象的实例变量会被还原成序列化之前的状态值。transient的变量会被赋予
     *    默认值。
     */
    private static void testRead() throws IOException, ClassNotFoundException {

        FileInputStream fileStream=new FileInputStream("Student.ser");
        ObjectInputStream os=new ObjectInputStream(fileStream);
        // 每次调用readObject都会都会从stream流中读取下一个对象，读取顺序与写入顺序相同，次数超出会抛出异常
        Object o1=os.readObject();
        Object o2=os.readObject();
        os.close();
        Student s1= (Student) o1;
        Student s2= (Student) o2;
        System.out.println("Student1.name="+s1.name);
        System.out.println("Student2.name="+s2.name);
    }

    public static void main(String[] args) {
        try {
            testWrite();
            testRead();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
