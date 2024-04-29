package com;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class ModeProblem {
    public static void main(String[] args) {
        int[] ints = modeProblem(new int[]{1, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5});
        System.out.println(Arrays.toString(ints));

    }
//排序 + 双指针
    public static int[] modeProblem(int[] nums) {
        shellSort(nums);
        int j = 0;
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i] || i == nums.length - 1) {
                if (i == nums.length - 1 && nums[j] == nums[i]) {
                    i++;
                }
                if (i - j > ret[1]) {
                    ret[0] = nums[j];
                    ret[1] = i - j;
                }
                j = i;
            }
        }
        return ret;
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;
                int insertNum = arr[i];
                while (insertIndex >= gap && arr[insertIndex - gap] > insertNum) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                if (insertIndex != i)
                    arr[insertIndex] = insertNum;
            }
        }
    }
}
