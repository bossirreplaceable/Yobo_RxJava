package com.yobo.yobo_rxjava.test1;


import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by ZhangBoshi
 * on 2020-03-25
 */
public class Test2 {


    public static void main(String[] args) {

       Observable<String> o= Observable.create(s->{

           s.onNext("你好啊");

        });

       o.map(i-> 222+i).subscribe(s-> System.out.println(s));

//        ArrayList<int> a=new ArrayList<>();

        ArrayList b=new ArrayList();
        b.add(22);



    }
}
