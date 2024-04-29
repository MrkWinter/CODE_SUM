package com.mrkwinter;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 3, 7, 9, 0, 4, 2, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        int first = start;
        int last = end;
        int middleNum = arr[start];
        int midIndex = start;
        while (start < end) {
            while (start < end && !(arr[end] < middleNum)) {
                end--;
            }
            arr[midIndex] = arr[end];
            arr[end] = middleNum;
            while (start < end && !(arr[start] > middleNum)) {
                start++;
            }
            arr[end] = arr[start];
            arr[start] = middleNum;
            midIndex = start;
        }
        if (midIndex - 1 > first)
            quickSort(arr, first, midIndex - 1);
        if (midIndex + 1 < last)
            quickSort(arr, midIndex + 1, last);
    }
}
