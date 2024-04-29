package com.mrkwinter;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,5,7,9,0,4,2,5,8};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j]>arr[j+1]){
                    arr[j] = arr[j+1]^arr[j];
                    arr[j+1] = arr[j]^arr[j+1];
                    arr[j]= arr[j]^arr[j+1];
                }
            }
        }
    }
}
