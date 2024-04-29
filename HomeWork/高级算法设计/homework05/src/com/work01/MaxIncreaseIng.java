package com.work01;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class MaxIncreaseIng {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 6, 9, 10, 4, 7, 8, 9, 10};
        int[] ints = new MaxIncreaseIng().maxIncreaseIng(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 最长连续递增
     *
     * @param arr
     * @return
     */
    public int[] maxIncreaseIng(int[] arr) {
        int begin = 0;
        int end = 1;
        int maxIncBegin = 0;
        int maxInc = 1;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                if (end - begin > maxInc) {
                    maxIncBegin = begin;
                    maxInc = end - begin;
                }
                begin = i;
            }
            end += 1;
        }
        if (arr[length - 1] > arr[length - 2]) {
            if (length - begin > maxInc) {
                maxIncBegin = begin;
                maxInc = end - begin;
            }
        }
        return Arrays.stream(arr).skip(maxIncBegin).limit(maxInc).toArray();
    }
}
