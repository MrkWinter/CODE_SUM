package com.dataStract.unit2._06dp;

import java.util.Arrays;

public class Test5 {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 6, 3, 9 };
//		int binarySearchIndex = binarySearchIndex(arr, 3, arr.length);
//		System.out.println(binarySearchIndex);
		int lsc = lsc(arr);
		System.out.println(lsc);
	}

	// 最长上升子序列 二分搜索法
	public static int lsc(int[] arr) {
		int num = 0;
		int[] result = new int[arr.length];
		Arrays.fill(result,Integer.MAX_VALUE);
		for (int i = 0 ; i < arr.length; i++) {
			int index = binarySearchIndex(result, arr[i], num);
			if (index > num) {
				num = index;
			}
			result[index] = arr[i];
		}
		return num + 1;
	}

	private static int binarySearchIndex(int[] result, int n, int num) {
		int left = 0;
		int right = num;
		int mid = 0;
		while (right - left >= 0) {
			mid = (left + right) >> 1;
			if (result[mid] >= n) {
				right = mid-1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
