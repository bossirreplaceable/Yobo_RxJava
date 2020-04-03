package com.yobo.yobo_rxjava.test3;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_Zip {

    public static void main(String[] args) {

        test();
    }

    public static void test() {

        Observable<Integer> o = Observable.just(1, 2, 3);
        Observable<Integer> o1 = Observable.just(3, 2, 1);

        Observable<Integer> zip = o.zipWith(o1, (a, b) -> a + b);

        Disposable d=zip.subscribe(System.out::println);

    }

}
