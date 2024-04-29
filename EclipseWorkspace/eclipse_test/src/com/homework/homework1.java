package com.homework;

import java.util.stream.Stream;

public class homework1 {
	public static void main(String args[]) {
		int[] arr = {1,2,5,7,9,0};
		ConnectNumMax(arr,4);
		System.out.print("a");
	}

	// 1计数一个数的阶乘
	public static int factorial1(int n) {
	   int result = 1;
	   for(int i = 1;i<=n;i++) {
		   result *=i;
	   }
	   return result;
	}
	public static int factorial2(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n * factorial2(n-1);
		}
	}
	// 2 找到数组中连续n个数最大的情况
	public static int[] ConnectNumMax(int[] arr,int n) {
		int[] result = new int[n+1];
		int maxNum = 0;
		int maxBegin = 0;
		for(int i = 0;i<n;i++) {
			maxNum +=arr[i];
		}
		for(int i = n;i<arr.length;i++) {
			if((maxNum-arr[i-n]+arr[n]) >maxNum) {
				maxNum = maxNum-arr[i-n]+arr[n];
				maxBegin = i-n+1;
			}
		}
		result[0] = maxBegin;
		for(int i = 0;i<n;i++) {
			result[i+1] = arr[maxBegin+i];
		}
		return result;
	}
}
