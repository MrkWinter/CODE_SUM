package com.dataStract.unit2._02searching;

import java.util.Arrays;

public class BinarySearching {
	public static int binarySearch(int[] arr,int n) {
		int left = 0;
		int right = arr.length;
		while(left <= right) {
			int mid = (left + right)>>1;
			if(arr[mid]>n) {
				right = mid-1;
			} else if(arr[mid]<n) {
				left = mid +1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr));
	}
}
