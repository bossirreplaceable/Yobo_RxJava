package com.yobo.yobo_rxjava.test_Algorithm;



/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_reverse {

    public static int reverse(int x) {

        boolean isZero = true;

        long r = 0;
        while (x !=0) {
            r*=10;
            long item = x % 10;
            x = x / 10;
            if (item != 0 || !isZero) {
                isZero = false;
                r = (r + item);
            }
        }
        if (r >Integer.MAX_VALUE||r<Integer.MIN_VALUE) {
            return 0;
        }
        return (int) r;

    }

    public static void main(String[] args) {
        System.out.println(""+reverse(-1200000999));
    }

}
