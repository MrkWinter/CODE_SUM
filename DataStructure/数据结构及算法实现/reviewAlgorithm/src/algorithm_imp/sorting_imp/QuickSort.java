package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */

/**
 * 2. 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 8, 3, 7, 9};
        quickSorting(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 原理 快速排序采用了递归的排序算法
     * 每一次通过确定一个数 将它假设成中间数 然后进行不断交换 将这个中间数放到合适的位置
     * 使其左边的数小于等于它 右边的数大于等于它 达到基本有序的效果
     * 然后使用递归 以中间数位置为界限 使其左边部分的数列按照同样的方法进行基本有序的操作
     * 到最后有序数列只剩三个数或更少的数时 就是完全有序的排列
     *
     * 不断交换 使加锁中间数位于中间有许多方法 这里是
     * 先从右边找一个较小数 和 中间数位置的元素交换
     * 再从右边找到一个较大数 和右边较大数位置(也就是中间数交换)
     * 重复以上操作
     *
     * 可以简化成
     * 先从右边找到一个较小数 赋值给中间数的位置
     * 再从左边找一个较大数 赋值给右边数的位置
     * 再将中间数赋值给左边数的位置
     * 这里中间数就在中间了
     * @param arr
     * @param begin
     * @param end
     */
    public static void quickSorting(int[] arr, int begin, int end) {
        int midNum = arr[begin];
        int leftIndex = begin;
        int rightIndex = end;
        //右边找小的 左边找大的
        while (leftIndex < rightIndex) {
            while (arr[rightIndex] >= midNum && leftIndex < rightIndex) {
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];
            while (arr[leftIndex] <= midNum && leftIndex < rightIndex) {
                leftIndex++;
            }
            arr[rightIndex] = arr[leftIndex];
            arr[leftIndex] = midNum;
        }
        if (leftIndex - 1 > begin) {
            quickSorting(arr, begin, leftIndex - 1);
        }
        if (leftIndex + 1 < end) {
            quickSorting(arr, leftIndex + 1, end);
        }
    }
}
