package com.dataStract.unit2._01sorting;

import java.util.Arrays;

public class HeadSorting {
	public static void headSorting(int[] arr) {
		heapify(arr, arr.length);
		for (int i = arr.length - 1; i >= 1; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			siftDown(arr, 0, i);
		}

	}

	public static void heapify(int[] arr, int size) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			siftDown(arr, i, arr.length);
		}
	}

	private static void siftDown(int[] arr, int i, int size) {
		int root = arr[i];
		while (i <= size / 2 - 1) {
			int reIndex = i * 2 + 1;
			if (reIndex + 1 < size && arr[reIndex] < arr[reIndex + 1]) {
				reIndex += 1;
			}
			if (root < arr[reIndex]) {
				arr[i] = arr[reIndex];
			}
			i = reIndex;
		}
		arr[i] = root;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		headSorting(arr);
		System.out.println(Arrays.toString(arr));
	}
}
