package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class MergeSorting {
	public static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		divise(arr, 0, arr.length, temp);
	}

	public static void divise(int[] arr, int begin, int end, int[] temp) {
		if (end - begin > 1) {
			int mid = (begin + end) / 2;
			divise(arr, begin, mid, temp);
			divise(arr, mid, end, temp);
			merge(arr, begin, mid, end, temp);
		}
	}

	public static void merge(int[] arr, int begin, int mid, int end, int[] temp) {
		for (int i = begin; i < end; i++) {
			temp[i] = arr[i];
		}
		int b = begin;
		int m = mid;
		int i = begin;
		while (b < mid && m < end) {
			if (temp[b] <= temp[m]) {
				arr[i++] = temp[b++];
			} else {
				arr[i++] = temp[m++];
			}
		}
		if (b == mid) {
			while (i < end) {
				arr[i++] = temp[m++];
			}
		} else {
			while (i < end) {
				arr[i++] = temp[b++];
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
