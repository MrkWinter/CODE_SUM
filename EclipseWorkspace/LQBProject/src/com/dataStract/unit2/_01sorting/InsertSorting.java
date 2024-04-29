package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class InsertSorting {
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int insNum = arr[i];
			int insertIndex = i;
			while (insertIndex > 0 && arr[insertIndex - 1] > insNum) {
				arr[insertIndex] = arr[insertIndex - 1];
				insertIndex--;
			}
			arr[insertIndex] = insNum;
		}
	}

	public static void insertSort2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int insNum = arr[i];
			int insertIndex = binSeachIndex(arr, insNum, i - 1);
			for (int j = i; j > insertIndex; j--) {
				arr[j] = arr[j - 1];
			}
			arr[insertIndex] = insNum;
		}
	}

	// 返回应插入索引
	public static int binSeachIndex(int[] arr, int n, int size) {
		int left = 0;
		int right = size;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) >> 1;

			if (arr[mid] > n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
//			if (arr[mid] < n) {
//				left = mid + 1;
//			} else {
//				right = mid - 1;
//			}
		}
		return left;
//等于情况在left  就是最右边 等于情况在right 就是最左边
	}

	public static int binSerIndex(int[] arr, int n) {
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (arr[mid] > n) {
				right = mid - 1;
			} else if (arr[mid] < n) {
				left = mid + 1;
			} else {
				while (arr[mid] == n) {
					mid++;
				}
				return mid - 1;
			}
		}
		if (left == mid + 1) {
			mid += 1;
		}
		return mid;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		insertSort2(arr);
		System.out.println(Arrays.toString(arr));
//		int[] arr2 = { 1, 3, 4, 6, 8, 10 };
//		int binSeachIndex = binSerIndex(arr2, 6);
//		System.out.println(binSeachIndex);

	}
}
