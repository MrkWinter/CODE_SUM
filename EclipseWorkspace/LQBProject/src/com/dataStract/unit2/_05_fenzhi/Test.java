package com.dataStract.unit2._05_fenzhi;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 1, -3, 2, 2, 3, -4, 0, 8 };
		int maxSubArr = maxSubArr(arr);
		System.out.println(maxSubArr);
	}

	public static int subArry(int[] arr) {
		int max = arr[0];
		int front = arr[0];
		for (int i = 1; i < arr.length; i++) {
			front = Math.max(front + arr[i], arr[i]);
			if (front > max) {
				max = front;
			}
		}
		return max;
	}

	public static int maxSubArr(int[] arr) {
		if (arr == null)
			throw new IllegalArgumentException("ddd");
		int end = arr.length;
		if (end < 2) {
			return arr[0];
		}
		return maxSubArr(arr, 0, end);

	}

	public static int maxSubArr(int[] arr, int begin, int end) {
		if (end - begin < 2) {
			return arr[begin];
		}
		int mid = (begin + end) >> 1;
		int leftSub = maxSubArr(arr, begin, mid);
		int rightSub = maxSubArr(arr, mid, end);
		int midSub = getmidSub(arr, begin, mid, end);
		return Math.max(Math.max(leftSub, rightSub), midSub);
	}

	private static int getmidSub(int[] arr, int begin, int mid, int end) {
		int leftMax = arr[mid - 1];
		int cur = leftMax;
		for (int i = mid - 2; i >= begin; i--) {
			cur += arr[i];
			if (cur > leftMax) {
				leftMax = cur;
			}
		}
		int rightMax = arr[mid];
		cur = rightMax;
		for (int i = mid + 1; i < end; i++) {
			cur += arr[i];
			if (cur > rightMax) {
				rightMax = cur;
			}
		}
		return leftMax + rightMax;
	}
}
