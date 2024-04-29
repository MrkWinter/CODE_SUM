package com.work01;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author MrkWinter
 * @version 1.0
 */

public class FindMaxContinue {
    public static void main(String[] args) {
        int[] maxContinue = new FindMaxContinue().findMaxContinue(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 2, 3}, 5);
        System.out.println(Arrays.toString(maxContinue));
    }
    /**
     * 找出数组中最大连续的数列表
     * @param length 最大连续数
     * @return 数组
     */
    public int[] findMaxContinue(int[] arr, int length) {
        if(arr.length<length)
            return arr;
        int maxBegin = 0;
        int maxSum = ((Function<int[], Integer>) ints -> {
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += arr[i];
            }
            return sum;
        }).apply(arr);
        int tempSum = maxSum;
        for (int i = length; i < arr.length; i++) {
            tempSum = tempSum-arr[(i-length)]+arr[i];
            if(tempSum>maxSum) {
                maxSum= tempSum;
                maxBegin = i-length+1;
            }
        }
        return Arrays.stream(arr).skip(maxBegin).limit(length).toArray();
    }
}
