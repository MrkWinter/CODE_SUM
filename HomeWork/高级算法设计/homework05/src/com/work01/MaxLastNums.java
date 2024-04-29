package com.work01;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class MaxLastNums {
    public static void main(String[] args) {
        int[] arr = {1, 2, -4, 5, 6, 3, -4, 3};
        int nums = new MaxLastNums().maxLastNums(arr);
        int nums2 = new MaxLastNums().maxLastNums2(arr);
        System.out.println(nums);
        System.out.println(nums2);
    }

    /**
     * 求最大子段和 不使用数组
     * @param arr
     * @return
     */
    public int maxLastNums2(int[] arr) {
        int tempMax = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tempMax = Math.max(tempMax + arr[i], arr[i]);
            if (tempMax > max)
                max = tempMax;
        }
        return max;
    }

    /**
     * 求最大子段和 使用数组
     *
     * @param arr
     * @return
     */
    public int maxLastNums(int[] arr) {
        int[] tempArr = new int[arr.length];
        tempArr[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tempArr[i] = Math.max(tempArr[i - 1] + arr[i], arr[i]);
            if (tempArr[i] > max)
                max = tempArr[i];
        }
        return max;
    }
}
