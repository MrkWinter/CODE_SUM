package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class QuickSorting {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int begin, int end) {
		int sureIndex = begin;
		int sureNum = arr[begin];
		int b = begin;
		int e = end;
		while (b <= e) {
			while (b <= e) {
				if (arr[e] <= sureNum) {
					arr[sureIndex] = arr[e];
					sureIndex = e--;
					break;
				}
				e--;
			}

			while (b <= e) {
				if (arr[b] >= sureNum) {
					arr[sureIndex] = arr[b];
					sureIndex = b++;
					break;
				}
				b++;
			}
		}
		arr[sureIndex] = sureNum;
		if (sureIndex - begin > 1) {
			quickSort(arr, begin, sureIndex - 1);
		}
		if (end - sureIndex > 1) {
			quickSort(arr, sureIndex + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
