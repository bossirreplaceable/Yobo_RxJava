package com.yobo.yobo_rxjava.test2;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_UnSubscribe {
    public static void main(String[] args) {
        Observable<String> a = Observable.create(s -> {
            s.onNext("A");
            s.onNext("B");
            s.onComplete();
            s.onNext("C");
        });


        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
//        a.subscribe(subscriber);


    }
}
