package com.yobo.yobo_rxjava.test_head;

import android.annotation.SuppressLint;

import java.util.Date;

/**
 * Created by ZhangBoshi
 * on 2020-04-01
 */
public class Test_Format {

    @SuppressLint("DefaultLocale")
    public static void main(String[] args) {

        /**
         * 给长数字添加 逗号分割
         * 输出结果：1,000,0000
         */
        String n = String.format("%,d", 1000000);
        System.out.println("n=" + n);

        /**
         * 保留小数点后几位
         * 输出结果：3.44
         */
        String f = String.format("%.2f", 3.44432);
        System.out.println("f=" + f);

        /**
         * 处理十进制整数的值，输入其他类型的数据会报错
         * 输出结果：10,000
         */
        String d = String.format("%,d", 10000);
        System.out.println("d=" + d);
        /**
         * 讲十进制转换为十六进制，参数必须是byte、short、int、long、BigInteger
         * 输出结果：2a
         */
        String h = String.format("%x", 42);
        System.out.println("h=" + h);
        /**
         * 讲十进制转换为char类型，参数必须是byte、short、int、long
         * 输出结果：*
         */
        String c = String.format("%c", 42);
        System.out.println("c=" + c);

        /**
         * 按指定类型输出事件
         * tc输出结果：星期三 四月 01 18:43:51 CST 2020
         * tr输出结果：06:43:51 下午
         * tD输出结果：04/01/20                   小写的td只会输出 01
         * ta输出结果：星期三, 四月, 01
         * ta1输出结果：星期三, 四月, 01           "<" 的作用就是复用参数
         */
        String tc = String.format("%tc", new Date());
        System.out.println("tc=" + tc);
        String tr = String.format("%tr", new Date());
        System.out.println("tr=" + tr);
        String tD = String.format("%tD", new Date());
        System.out.println("tD=" + tD);
        String ta = String.format("%tA, %tB, %td", new Date(), new Date(), new Date());
        System.out.println("ta=" + ta);
        String ta1 = String.format("%tA, %<tB, %<td", new Date());
        System.out.println("ta1=" + ta1);

    }

}
