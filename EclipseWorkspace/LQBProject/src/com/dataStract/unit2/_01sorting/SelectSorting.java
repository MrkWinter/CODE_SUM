package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class SelectSorting {
	public static void selectSort(int[] arr) {
		for (int i = arr.length-1; i > 0 ; i--) {
			int maxIndex = 0;
			int maxNum = arr[0];
			for (int j = 1; j <= i; j++) {
				if(arr[j]>arr[maxIndex]) {
					maxIndex = j;
					maxNum = arr[j];
				}
			}
			arr[maxIndex] = arr[i];
			arr[i] = maxNum;
		}
	}
	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
