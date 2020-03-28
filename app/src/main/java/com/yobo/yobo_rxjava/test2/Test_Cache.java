package com.yobo.yobo_rxjava.test2;

import com.yobo.yobo_rxjava.Utils;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_Cache {

    public static void main(String[] args) {
        Observable<String> a = Observable.create(s -> {
            Utils.log("Create");
            s.onNext("A");
            s.onNext("B");
            s.onComplete();
        });

        a.subscribe(System.out::println);
        a.subscribe(System.out::println);

        Utils.logLine();

        Observable<Object> b = Observable.create(s -> {
            Utils.log("Create");
            s.onNext("A");
            s.onNext("B");
            s.onComplete();
        }).cache();

        b.subscribe(System.out::println);
        b.subscribe(System.out::println);
    }

}
