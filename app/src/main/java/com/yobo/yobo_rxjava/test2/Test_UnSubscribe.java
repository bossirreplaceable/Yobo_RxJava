package com.yobo.yobo_rxjava.test2;

import android.text.TextUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.HashMap;
import java.util.Map;

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

        String b=" ";
        System.out.println("b.length="+b.length()+",i="+((int)b.charAt(0)));
        Map<Character, Integer> m=new HashMap<>();
//        m.put(b.charAt(2),1);
    }
}
