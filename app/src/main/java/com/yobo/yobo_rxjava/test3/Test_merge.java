package com.yobo.yobo_rxjava.test3;

import com.yobo.yobo_rxjava.Utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_merge {

    public static void main(String[] args) {

        test();
    }

    private static void test() {

        Observable<String> o1 = Observable.interval(900, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x + "-号");
        Observable<String> o2 = Observable.interval(900, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x * 2 + "-号");
        Observable<String> o3 = Observable.interval(900, TimeUnit.MILLISECONDS).take(5)
                .map(x -> x * 3 + "-号");


        Observable<String> all = Observable.merge(o1, o2, o3);
        Disposable d = all.subscribe(System.out::println);
        Utils.sleep(12, TimeUnit.SECONDS);
    }
}
