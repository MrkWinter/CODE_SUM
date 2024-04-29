package algorithm_imp.sorting_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.Arrays;

/**
 * 1. 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,8,3,7,9};
        bubbleSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true; //可以退出
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j+1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
            if (flag)
                return;
        }
    }
}
