package com.yobo.yobo_rxjava.test3.test3_3;

import com.yobo.yobo_rxjava.Utils;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

/**
 * Created by ZhangBoshi
 * on 2020-04-03
 */
public class Test_scan_reduce {

    public static void main(String[] args) {
       test1();

    }

    private static void test(){
        Observable<Integer> source = Observable.just(10, 12, 13, 16, 26, 20);

        Observable<Integer> o = source.scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                Utils.log("integer="+integer+",integer2="+integer2);
                return integer + integer2;
            }
        });

        Observable<Integer> o1 = source.scan(3,(total, chunk) -> {
            Utils.log("total="+total+",chunk="+chunk);
            return total + chunk;
        });
        Disposable d=o1.subscribe(System.out::println);
    }

    private static void test1(){
        Observable<Integer> source = Observable.just(10, 12, 13, 16, 26, 20);

        Maybe<Integer> o = source.reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                Utils.log("integer="+integer+",integer2="+integer2);
                return integer+integer2;
            }
        });
        Single<Integer> o1 = source.reduce((integer, integer2) -> {
            Utils.log("integer="+integer+",integer2="+integer2);
            return integer+integer2;
        }).toSingle();

        Disposable d=o1.subscribe(System.out::println);

    }


}
