package com.yobo.yobo_rxjava.test3;

import com.yobo.yobo_rxjava.Utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_concatMap {


    public static void main(String[] args) {

        test2();
    }


    public static void test(){
        Observable<Integer> o = Observable.just(1, 2, 3);
        Observable<Integer> o1 = o.delay(i -> Observable.timer(2, TimeUnit.SECONDS));
        Observable<Integer> o2 = o.flatMap(i -> Observable.timer(2, TimeUnit.SECONDS).map(x -> i*4));
        Observable<Integer> o3=o.concatMap(x->o1);
        Observable<Integer> o4=o.concatMap(x->o2);
        Disposable d=o3.subscribe(System.out::println);
        Disposable d1=o4.subscribe(System.out::println);
        Utils.sleep(12,TimeUnit.SECONDS);
    }

    public static void test1(){

        Observable<Integer> o = Observable.just(1, 2, 3);
        Observable<String> o1 = o.flatMap(Test_concatMap::getO);

        Disposable d=o1.subscribe(System.out::println);
        Utils.sleep(10,TimeUnit.SECONDS);

    }

    public static void test2(){

        Observable<Integer> o = Observable.just(1, 2, 3);
        Observable<String> o1 = o.concatMap(Test_concatMap::getO);

        Disposable d=o1.subscribe(System.out::println);
        Utils.sleep(13,TimeUnit.SECONDS);

    }

    private static Observable<String> getO(int i){

        if (i==1){
            return Observable.interval(900,TimeUnit.MILLISECONDS).take(5).map(x->x+"-号");
        }else if (i==2){
            return Observable.interval(600,TimeUnit.MILLISECONDS).take(5).map(x->x*2+"-号");
        }else {
            return Observable.interval(750,TimeUnit.MILLISECONDS).take(5).map(x->x*3+"-号");
        }
    }

}
