package algorithm_imp.sorting_imp;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */

/**
 * 7.归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
            int[] arr = {2, 4, 1, 5, 8, 3, 7, 9};
            int[] temp = new int[arr.length];
            mergeSorting(arr,0,arr.length-1, temp);
            System.out.println(Arrays.toString(arr));

    }

    /**
     * 原理 归并排序的原理是 基本有序的两个数组可以用按大小顺序拼接的形式形成一个有序的大数组
     * 归并排序 中将数组分解成最小两个数的小数组后可以进行按大小拼接排序 形成一个有序的的数组
     * 由此 当合并成原数数组大小时 原数组变成有序数组
     * 分解中最重要的就是找中间值和左右两边的值 由递归不断分解
     * 到达最小时进行合并
     */
    public static void mergeSorting(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSorting(arr, left, mid, temp);
            mergeSorting(arr, mid + 1, right, temp);
            System.out.println("xxxx");
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        if (i > mid) {
            while (j <= right) {
                temp[t++] = arr[j++];
            }
        }
        if (j > right) {
            while (i <= mid) {
                temp[t++] = arr[i++];
            }
        }
        int index = left;
        for (int k = 0; k < t; k++) {
            arr[index++] = temp[k];
        }
    }

}
