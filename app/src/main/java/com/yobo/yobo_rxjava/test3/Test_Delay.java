package com.yobo.yobo_rxjava.test3;

import com.yobo.yobo_rxjava.Utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_Delay {

    public static void main(String[] args) {

//        test();
        test1();
    }

    /**
     * 如果你在延时完成之前订阅它，是接受不到消息的，你必须在它延时之后订阅才会接收到消息。
     */
    public static void test() {

        Observable<Integer> o = Observable.just(1, 2, 3);

        Observable<Integer> o1 = o.delay(3, TimeUnit.SECONDS);
        Observable<Integer> o2 = Observable.timer(3, TimeUnit.SECONDS)
                .flatMap(i -> Observable.just(1, 2, 3));

        Disposable d = o.subscribe(System.out::println);

        Disposable d1 = o1.subscribe(System.out::println);
        System.out.println("------------------------------");
        Disposable d2 = o2.subscribe(System.out::println);
        System.out.println("------------------------------");
        Utils.sleep(5, TimeUnit.SECONDS);
    }

    /**
     * 1、delay要比timer功能更强大，它会将每个事件都放在给定的时间之后再发布；
     * 2、timer只是进行"休眠"，在给定的时间之后发布一个特定的事件。
     * 注意：这里需要给main函数的主线程休眠相同的时间，如果不休眠的话，因为Observable是不阻塞的，
     *      整个test函数在几毫秒内就执行完毕,并被释放，所以不会有任何输出。
     */

    public static void test1() {

        Observable<Integer> o = Observable.just(1, 2, 3);
        Observable<Integer> o1 = o.delay(i -> Observable.timer(2, TimeUnit.SECONDS));
        Observable<Integer> o2 = o.flatMap(i -> Observable.timer(2, TimeUnit.SECONDS).map(x -> i));

        System.out.println("------------------------------");
        Disposable d1 = o1.subscribe(System.out::println);
        System.out.println("------------------------------");
        Disposable d2 = o2.subscribe(System.out::println);
        System.out.println("------------------------------");
        Observable.just(6, 7, 8).delay(i -> Observable.timer(2, TimeUnit.SECONDS))
                .subscribe(System.out::println);
        Utils.sleep(6, TimeUnit.SECONDS);
    }

}
