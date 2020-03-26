package com.yobo.yobo_rxjava.test1

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by ZhangBoshi
 * on 2020-03-02
 */


fun main() {

    testA()
}


fun testA() {

    val observable =
        Observable.create<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
        }

    val observer: Observer<Int?> = object : Observer<Int?> {
        override fun onSubscribe(d: @NonNull Disposable?) {

        }

        override fun onNext(integer: @NonNull Int?) {
            println("Hello-$integer")

        }

        override fun onError(e: @NonNull Throwable?) {

        }

        override fun onComplete() {

        }
    }
    observable.subscribe(observer)

//
//    val observable1:Observable<String?> = Observable.just("A", "B", "C")
//
//    val words = arrayOf("a", "b", "c")
//
//    val observable2=Observable.fromArray(words)
//

//
//    val subscriber: Subscriber<String?> = object : Subscriber<String?> {
//        override fun onSubscribe(s: Subscription) {}
//        override fun onNext(s: String?) {
//            println("你好-$s")
//        }
//        override fun onError(t: Throwable) {}
//        override fun onComplete() {}
//    }


//    observable1.subscribe(subscriber)

}


