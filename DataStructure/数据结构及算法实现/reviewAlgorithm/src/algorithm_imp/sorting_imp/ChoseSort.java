package algorithm_imp.sorting_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.Arrays;

/**
 * 5.选择排序
 */
public class ChoseSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 8, 3, 7, 9};
        choseSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void choseSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
