package com.yobo.yobo_rxjava.test3;

import com.yobo.yobo_rxjava.Utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_combineLatest {

    public static void main(String[] args) {

        test2();
        Utils.sleep(10,TimeUnit.SECONDS);
    }

    private static void test() {

        Observable<String> o1 = Observable.interval(900, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x + "-号");
        Observable<String> o2 = Observable.interval(500, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x * 2 + "-号");

        Observable<String> combine = Observable.combineLatest(o1, o2, (a, b) -> a + ":" + b);
        Disposable d = combine.subscribe(System.out::println);

    }

    private static void test1() {

        Observable<String> o1 = Observable.interval(900, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x + "-号");
        Observable<String> o2 = Observable.interval(500, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x * 2 + "-号");

        Observable<String> combine = o1.withLatestFrom(o2, (a, b) -> a + ":" + b);
        Disposable d = combine.subscribe(System.out::println);

    }


    private static void test2() {

        Observable<String> o1 = Observable.interval(900, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x + "-号").doOnSubscribe(x->Utils.log("Subscribe:o1")).doOnDispose(()->Utils.log("UnSubscribe:o1"));
        Observable<String> o2 = Observable.interval(500, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x * 2 + "-号").doOnSubscribe(x->Utils.log("Subscribe:o2")).doOnDispose(()->Utils.log("UnSubscribe:o2"));

        Observable<String> combine = Observable.ambArray(o1,o2);
        Disposable d = combine.subscribe(System.out::println);

    }
}
