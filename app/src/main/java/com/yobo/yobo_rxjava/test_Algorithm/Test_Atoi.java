package com.yobo.yobo_rxjava.test_Algorithm;

import java.math.BigInteger;

/**
 * Created by ZhangBoshi
 * on 2020-04-02
 */
public class Test_Atoi {

    public static int myAtoi(String str) {

        StringBuilder b = new StringBuilder();

        int index=0;
        while (index<str.length()) {
             char c=str.charAt(index);
            if ((c == 45 || c == 43)) {
                if (b.length() == 0) {
                    b.append(c);
                } else {
                    break;
                }
            } else if (c > 47 && c < 58) {
                b.append(c);
            } else if (c == 32 && b.length() != 0) {
                break;
            } else if (c != 32) {
                break;
            }
            index++;
        }
        if (b.length() == 0 || (b.length() == 1 && b.charAt(0) < 48)) {
            return 0;
        }

        double a = Double.valueOf(String.valueOf(b));
        if (a > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (a < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) a;
        }
    }

    public static void main(String[] args) {

        System.out.println("" + myAtoi("  -1 42"));
        // System.out.println(""+Integer.parseInt(" 21"));
    }
}
