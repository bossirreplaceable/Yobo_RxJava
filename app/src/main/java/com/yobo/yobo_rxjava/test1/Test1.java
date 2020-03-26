package com.yobo.yobo_rxjava.test1;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-03-02
 */
public class Test1 {
    public static void main(String[] args) {

        Flowable.just("你好啊").subscribe(System.out::println);
        //
        Observable.create(s -> {
            s.onNext("hello小子");
            s.onComplete();
        }).subscribe(hello -> System.out.println(hello));

        // test1();
    }

    private static void test1() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {

                emitter.onNext("你好啊");
                System.out.println("Observable.Thread.name=" + Thread.currentThread().getName());
                emitter.onNext("我不好");
                emitter.onComplete();

            }
        });
        String[] words = { "a", "b", "c" };

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String integer) {

                System.out.println("Observer.Thread.name=" + Thread.currentThread().getName());
                System.out.println("输出=" + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }
}
