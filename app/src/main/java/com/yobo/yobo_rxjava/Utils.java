package com.yobo.yobo_rxjava;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Utils {

    public static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ":" + s);
    }

    public static void logLine() {
        System.out.println(Thread.currentThread().getName() + ":------------------------"  );
    }

    public static void sleep(int timeout, TimeUnit unit) {
        try {
            unit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
