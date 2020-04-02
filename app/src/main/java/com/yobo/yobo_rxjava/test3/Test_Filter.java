package com.yobo.yobo_rxjava.test3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * Created by ZhangBoshi
 * on 2020-04-01
 */
public class Test_Filter {


    public static void main(String[] args) {
        testFilter();
    }


    public static void testFilter(){

        Observable<Integer> a = Observable.<Integer>create(s -> {
            s.onNext(3);
            s.onNext(10);
            s.onNext(22);
            s.onNext(33);
            s.onNext(55);
            s.onComplete();
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Throwable {
                return integer<50;
            }
        }).filter(i-> i>20);

        a.subscribe(System.out::println);


    }
}
