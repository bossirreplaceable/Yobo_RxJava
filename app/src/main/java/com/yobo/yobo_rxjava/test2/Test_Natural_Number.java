package com.yobo.yobo_rxjava.test2;

import java.math.BigInteger;
import java.util.Iterator;


/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_Natural_Number {

    /**
     * 无穷自然数的的实现
     */
    class NaturalNUmber implements Iterator<BigInteger> {

        private BigInteger current=BigInteger.ZERO;
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public BigInteger next() {
            current = current.add(BigInteger.ONE);
            return current;
        }
    }

    public static void main(String[] args) {


    }
}
