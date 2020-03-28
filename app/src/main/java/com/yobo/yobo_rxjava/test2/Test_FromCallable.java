package com.yobo.yobo_rxjava.test2;

import com.yobo.yobo_rxjava.Utils;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_FromCallable {

    public static void main(String[] args) {


       Observable<String> a= Observable.fromCallable(new Callable<String >() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                try {
                    throw new Throwable("你好的");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                return "你好";
            }
        });


       a.subscribe(new Observer<String>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(String s) {

               Utils.log(s);
           }

           @Override
           public void onError(Throwable e) {

               e.printStackTrace();
           }

           @Override
           public void onComplete() {

           }
       });
    }
}
