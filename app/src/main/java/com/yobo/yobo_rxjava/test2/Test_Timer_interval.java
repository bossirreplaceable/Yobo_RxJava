package com.yobo.yobo_rxjava.test2;

import com.yobo.yobo_rxjava.Utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZhangBoshi
 * on 2020-03-28
 */
public class Test_Timer_interval {

    public static void main(String[] args) {

        Utils.log("" + System.currentTimeMillis());
        Disposable o = Observable.just("我3秒不发布就超时报错").timeout(3000, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        Utils.log("" + System.currentTimeMillis());

        Disposable d = Observable.interval(0, 1, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("aa");
                Utils.log("" + aLong);
            }
        });

        Utils.sleep(20,TimeUnit.SECONDS);


        // int[] a=new int[]{2,7,11,15};
        // int[] result=twoSum(a,9);

    }

    public static int[] twoSum(int[] nums, int target) {

        int N = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < N; i++) {
            int key = target - nums[i];
            System.out.println("i=" + key);
            result[0] = i;
            if (key < 0)
                continue;
            for (int j = 0; j < N; j++) {
                if (nums[j] == key) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;

    }

    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
            int key = target - nums[i];
            // if(m.containsKey()&&m.get())

        }

        return null;
    }
}
