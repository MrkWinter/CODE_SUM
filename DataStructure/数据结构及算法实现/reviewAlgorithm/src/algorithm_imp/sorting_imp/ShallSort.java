package algorithm_imp.sorting_imp;

import java.util.Arrays;


/**
 * @author MrkWinter
 * @version 1.0
 */

/**
 * 希尔排序
 */
public class ShallSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 8, 3, 7, 9};
        shallSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序原理
     * 希尔排序是进阶版的插入排序
     * 它的原理是先将数据分成许多组 相同的组之间进行交换 以达到减少交换的效果
     * 第一次分成length/2个组 第二次分成length/4个组 直到全部数据分成一个组
     * 进行的插入排序效果更快
     *
     * @param arr
     */
    public static void shallSorting(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;
                int insertNum = arr[i];
                while (insertIndex - gap >= 0 && arr[insertIndex - gap] > insertNum) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertNum;
            }
        }
    }

}
