package com.yobo.yobo_rxjava.test3;

import com.yobo.yobo_rxjava.Utils;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * Created by ZhangBoshi
 * on 2020-04-01
 */
public class Test_Map {

    public static void main(String[] args) {
        testFilter();
    }

    public static void testFilter() {

        Observable<Integer> a = Observable.create(s -> {
            s.onNext(3);
            s.onNext(10);
            s.onNext(22);
            s.onNext(33);
            s.onNext(55);
            s.onComplete();
        });

        Observable<Integer> b = a.filter(i -> i > 20);

        Observable<String> c=b.map(s-> s+"-a");

        Observable<String> d=c.map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Throwable {
                return s+"-b";
            }
        });

        a.subscribe(System.out::println);
        System.out.println("-----------------");
        b.subscribe(System.out::println);
        System.out.println("-----------------");
        c.subscribe(System.out::println);
        System.out.println("-----------------");
        d.subscribe(System.out::println);

    }
}
