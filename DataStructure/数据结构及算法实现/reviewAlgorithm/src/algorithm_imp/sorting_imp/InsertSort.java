package algorithm_imp.sorting_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.Arrays;

/**
 * 3.插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 8, 3, 7, 9};
        insertSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i;
            int insertNum = arr[i];
            while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertNum) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex -= 1;
            }
            arr[insertIndex] = insertNum;
        }
    }

}
