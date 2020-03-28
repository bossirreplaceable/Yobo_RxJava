package com.yobo.yobo_rxjava.test2;

import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_2_1 {

    public static void main(String[] args) {

        Observable<String> a = Observable.create(s -> {
            s.onNext("A");
            s.onNext("B");
            s.onComplete();
            s.onNext("C");
        });

        a.subscribe((String s) -> {
            System.out.println(s);
        }, (Throwable t) -> {
            t.printStackTrace();
        }, () -> {
            System.out.println("输出完成");
        });

       Disposable s;

       s=a.subscribe(
                System.out::println,
                Throwable::printStackTrace
                );

        System.out.println("s="+s.isDisposed());
        s.dispose();
        System.out.println("s="+s.isDisposed());

    }
}
