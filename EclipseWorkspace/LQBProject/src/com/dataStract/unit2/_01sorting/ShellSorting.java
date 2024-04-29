package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class ShellSorting {
	public static void shellSort(int[] arr) {
		for (int step = arr.length >> 1; step > 0; step >>= 1) {
			for (int i = step; i < arr.length; i++) {
				int insertIndex = i;
				int insertNum = arr[i];
				while (insertIndex - step >= 0 && arr[insertIndex - step] > insertNum) {
					arr[insertIndex] = arr[insertIndex - step];
					insertIndex -=step;
				}
				arr[insertIndex] = insertNum;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
