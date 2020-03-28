package com.yobo.yobo_rxjava.test1;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_Stream {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        String[] b = new String[] { "A", "B", "C" };
        Stream.of(b).skip(1).limit(2).map(s -> s + "AAA").forEach(System.out::println);
        System.out.println("--------------");

        ArrayList<String> c = new ArrayList<>();
        c.add("X");
        c.add("Y");
        c.add("Z");
        Stream.of(c).map(s -> s + "OOO").forEach(System.out::println);

        System.out.println("--------------");
        Observable.create(s -> {
            s.onNext("A");
            s.onNext("B");
            s.onNext("C");
        }).skip(1).take(2).map(s -> s + "CCC").forEach(System.out::println);
    }
}
