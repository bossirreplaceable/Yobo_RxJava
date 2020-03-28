package com.yobo.yobo_rxjava.test2;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_Create_Observable {


    public static void main(String[] args) {


        //方式一
        Observable<String> a=Observable.just("你好");

        ArrayList<String> data = new ArrayList<>();
        data.add("A");
        data.add("B");
        data.add("C");

        Observable b=Observable.fromArray(data);


        Observable c=Observable.range(5,3);

        Observable d=Observable.empty();

        Observable e=Observable.never();

        Observable f=Observable.error(new Throwable("我是一个Error"));

        f.subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Object o) {
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        });

        Observable g=Observable.merge(a,b);
        g.subscribe(System.out::println);
        c.subscribe(System.out::println);



    }




}
