package com.yobo.yobo_rxjava.test1;

import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by ZhangBoshi
 * on 2020-03-26
 */
public class Test_merge {

    public static void main(String[] args) {

        testMerge();
    }

    private static void testMerge() {

        Observable o1 = Observable.create(s -> {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("o1开始执行");
                    s.onNext("one");
                    s.onNext("two");
                    s.onNext("three");
                }
            }).start();

        });
        Observable o2 = Observable.create(s -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    s.onNext("four");
                    s.onNext("five");
                    s.onNext("six");
                }
            }).start();
        });

        Observable o3 = Observable.merge(o1, o2);

        o3.subscribe(System.out::println);
        o3.subscribe(System.out::println);


    }
}
