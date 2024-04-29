package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class BubbleSorting {

	// 1. 冒泡排序三种方法 不断优化
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j + 1];
					arr[j] = arr[j] ^ arr[j + 1];
				}
			}
		}
	}

	public static void bubbleSort2(int[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			flag = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j + 1];
					arr[j] = arr[j] ^ arr[j + 1];
				}
			}
			if (!flag)
				break;
		}
	}

	public static void bubbleSort3(int[] arr) {
		for (int end = arr.length - 1, fin = end; end > 0; end = fin) {
			for (int j = 0; j < end; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					fin = j;
				}
			}
			if (fin == end)
				break;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		bubbleSort3(arr);
		System.out.println(Arrays.toString(arr));
	}
}
