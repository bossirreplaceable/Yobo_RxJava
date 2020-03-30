package com.yobo.yobo_rxjava.test2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangBoshi
 * on 2020-03-30
 */
public class Test_SubString {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 1;
        int add = 1;
        Map<Integer, Integer> m = new HashMap<>();
        m.put((int) s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            if (!m.containsKey((int) s.charAt(i))) {
                m.put((int) s.charAt(i), i);
                ++add;
            } else {
                i=m.get((int)s.charAt(i));
                m.clear();
                if (add > count) {
                    count = add;
                }
                m.put((int) s.charAt(i), i);
                add = 1;
            }
        }
        if (add>count){
            count=add;
        }

        return count;

    }

    public static void main(String[] args) {

        String a="au";
        System.out.println(lengthOfLongestSubstring(a)+"");
    }
}
