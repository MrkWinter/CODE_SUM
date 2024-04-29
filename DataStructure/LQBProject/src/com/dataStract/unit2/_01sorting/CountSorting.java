package com.dataStract.unit2._01sorting;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class CountSorting {
	//不稳定 计数排序
	public static void countSort(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		int[] count = new int[Math.abs(max - min) + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}
		int dex = 0;
		for (int i = 0; i < arr.length; i++) {
			while (count[dex] == 0) {
				dex++;
			}
			arr[i] = dex + min;
			count[dex]--;
		}
	}
	//稳定  可排序负数  但仍需要较大空间 计数排序
	public static void countSort2(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int[] count = getCount(arr, max, min);
		int[] newArr = Arrays.copyOf(arr, arr.length);
		for (int i = arr.length-1; i >= 0; i--) {
			arr[--count[newArr[i]-min]] = newArr[i];
		}
	}
	public static int[] getCount(int[] arr,int max,int min) {
		int[] count = new int[max - min + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 5, 8, 0, 3, 4, 7, 9 };
		countSort2(arr);

		System.out.println(Arrays.toString(arr));
	}
}
