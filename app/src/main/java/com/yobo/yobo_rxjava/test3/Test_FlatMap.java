package com.yobo.yobo_rxjava.test3;

import androidx.annotation.NonNull;

import com.yobo.yobo_rxjava.Utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_FlatMap {

    public static void main(String[] args) {
        // test();
        test2();

    }

    /**
     * 1、flatMap的返回的对象是一个内嵌的Observable ，也就是你可以在flatMap函数中去订阅另一个Observable，
     * 然后得到它的结果。
     * 2、如果你使用map函数来做同样的操作的话，返回的将是 Observable<Observable<Integer>>的数据类型，
     * 而且你在输出的时候还需要讲每个嵌套的Observable都订阅了才能输出。
     */
    /**
     * 适用场景：
     * 1、map()转换的结果必须是Observable。比如，对流中的每个元素执行长时间运行的异步操作，这些操作是非阻塞的。
     * 2、需要进行一对多转换，一个事件要被扩展为多个事件。例如：客户组成的流要转换成客户自身的订单流，每个客户的
     * 订单是有很多的。
     */
    private static void test() {

        Observable<String> o = Observable.just("A", "B", "C");
        Observable<Integer> number = Observable.just(1, 2, 3);
        Observable<Integer> n1 = number.map(x -> x * 3);
        Observable<Integer> n2 = number
                .flatMap(new Function<Integer, ObservableSource<? extends Integer>>() {
                    @Override
                    public ObservableSource<? extends Integer> apply(Integer integer)
                            throws Exception {
                        return Observable.just(integer * 2);
                    }
                });
        Observable<Integer> n3 = number
                .flatMap(x -> Observable.just(x).map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        Utils.sleep(3, TimeUnit.SECONDS); // 睡眠三秒
                        Utils.log(integer);// 打印 线程名：integer

                        return x * 4;
                    }
                }));

        Observable<Observable<Integer>> n4 = number.map(Test_FlatMap::getNumber);

        System.out.println("----------输出结果为：1、2、3-------------");
        Disposable d = number.subscribe(System.out::println);
        System.out.println("----------输出结果为：3、6、9-------------");
        Disposable d1 = n1.subscribe(System.out::println);
        System.out.println("----------输出结果为：2、4、6-------------");
        Disposable d2 = n2.subscribe(System.out::println);
        System.out.println("----------输出结果为：4、8、12-------------");
        Disposable d3 = n3.subscribe(System.out::println);
        System.out.println("----------输出结果为：5、10、15-------------");
        Disposable d4 = n4.subscribe(x -> x.subscribe(System.out::println));

    }

    private static Observable<Integer> getNumber(Integer i) {
        Utils.sleep(3, TimeUnit.SECONDS); // 睡眠三秒
        Utils.log(i);
        return Observable.just(i * 5);
    }

    /**
     * 如果你要把你数据源中的每个item，转换成Iterator形式的，可以按照o1和o2的形式实现。
     */
    public void test1() {

        Observable<Integer> o = Observable.just(1, 2, 3);

        Observable<Iterable<Integer>> o1 = o.flatMap(x -> Observable.just(getIt(x)));
        Observable<Iterable<Integer>> o2 = o.map(Test_FlatMap::getIt).flatMap(Observable::just);

        Observable<Iterable<Integer>> o3 = o.<Iterable<Integer>> flatMapIterable(
                new Function<Integer, Iterable<? extends Iterable<Integer>>>() {
                    @Override
                    public Iterable<? extends Iterable<Integer>> apply(Integer integer)
                            throws Exception {
                        return Collections.singleton(getIt(integer));
                    }
                });

    }

    public static Iterable<Integer> getIt(Integer i) {
        return new Iterable<Integer>() {
            @NonNull
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    @Override
                    public boolean hasNext() {
                        return true;
                    }

                    @Override
                    public Integer next() {
                        return i;
                    }
                };
            }
        };
    }

    /**
     * 还可以拦截 error 和complete事件
     * 注意：必须返回相同类型的Observable ，并且不能返回null；
     */
    public static void test2() {

        Observable<Integer> o = Observable.create(s -> {
            s.onNext(1);
            s.onError(new Throwable("你好"));
            s.onComplete();
        });
        Observable o1 = o.flatMap(integer -> Observable.empty(), Test_FlatMap::error,
                Test_FlatMap::complete);

        Observable o2 = o.flatMap(new Function<Integer, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Integer integer) throws Exception {
                Utils.log(integer);
                return Observable.just(1);
            }
        }, new Function<Throwable, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Throwable throwable) throws Exception {
                Utils.log(throwable.getMessage());
                return Observable.just(1);
            }
        }, new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
                Utils.log("事件完成");
                return Observable.just(1);
            }
        });

        // o1.subscribe();
        o1.subscribe();
        o2.subscribe();

    }

    public static Observable error(Throwable t) {
        System.out.println("error-t=" + t.getMessage());
        return Observable.just(1);
    }

    public static Observable complete() {
        System.out.println("complete-事件完成");
        return Observable.just(1);
    }
}
