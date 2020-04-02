package com.yobo.yobo_rxjava.test2;

import com.yobo.yobo_rxjava.Utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-04-01
 */
public class Test_RefCount_Publish {

    public static void main(String[] args) {

        test();
        testPublish();
    }

    private static void test() {

        Observable<String> o = Observable.create(s -> {
            Utils.log("Establishing connection");
            s.onNext("输出：你好啊");

        });

        Disposable a = o.subscribe(System.out::println);
        Utils.log("Subscribed 1");
        System.out.println("------------------------");
        Disposable b = o.subscribe(System.out::println);
        Utils.log("Subscribed 2");
    }

    private static void testPublish() {

        System.out.println("----------------------");
        Observable<Object> o = Observable.create(s -> {
            Utils.log("Establishing connection 1");
            s.onNext("输出：我不好");

        }).publish().refCount();

        Disposable a = o.subscribe(System.out::println);
        Utils.log("Subscribed 1");
        System.out.println("------------------------");

        Disposable b = o.subscribe(System.out::println);
        Utils.log("Subscribed 2");
        System.out.println("------------------------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Utils.sleep(3, TimeUnit.SECONDS);
                o.subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("我订阅了你");
                        System.out.println(o);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                Utils.log("Subscribed 3");
            }
        }).start();

    }
}
