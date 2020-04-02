package com.yobo.yobo_rxjava.test2;

import com.yobo.yobo_rxjava.Utils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by ZhangBoshi
 * on 2020-04-01
 */
public class Test_Connect_Observable {

    public static void main(String[] args) {

        testConnnectable();
        test();
    }

    private static void testConnnectable() {

        ConnectableObservable<String> o = Observable.<String>create(s -> {
            Utils.log("Establishing connection");
            s.onNext("Message：Hello");

        }).publish();

        Disposable a = o.subscribe(s -> {
            Utils.log("a：Accept Message!");
            Utils.log("a: "+s);
        });
        Utils.log("Subscribed a");
        o.connect();
        System.out.println("------------------------");
        Disposable b = o.subscribe(s -> {
            Utils.log("b：Accept Message!");
            Utils.log("b: "+s);
        });
        Utils.log("Subscribed b");

    }

    private static void test() {

        System.out.println("---------------------");
        Observable<String> o = Observable.create(s -> {
            Utils.log("Establishing connection");
            s.onNext("Message：Hello");

        });

        Disposable a = o.subscribe(s -> {
            Utils.log("a：Accept Message!");
            Utils.log("a: "+s);
        });
        Utils.log("Subscribed a");
        System.out.println("------------------------");
        Disposable b = o.subscribe(s -> {
            Utils.log("b：Accept Message!");
            Utils.log("b: "+s);
        });
        Utils.log("Subscribed b");

//        o.connect();
    }





}
