package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class RedixSorting {
	public static void redixSort(int[] arr) {

		int[] count = new int[10];
		int length = Integer.toString(Arrays.stream(arr).max().getAsInt()).length();
		for (int i = 1; i <= length; i++) {
			rSort(arr,count, i);
			Arrays.fill(count, 0);
		}
	}

	// 这里使用计数排序实现基数排序 也可以使用桶来实现
	public static void rSort(int[] arr, int[] count, int bx) {
		int div = (int) Math.pow(10, bx - 1);
		int[] copyOf = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] / div % 10]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		for (int i = copyOf.length - 1; i >= 0; i--) {
			arr[--count[copyOf[i] / div % 10]] = copyOf[i];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9, 11, 111, 100 };
		redixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
