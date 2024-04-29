package com.dataStract.unit2._06dp;

public class Test2 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 3, 2, 3 };
		int long1 = new Test2().getLong2(arr);
		System.out.println(long1);
	}

//	public int getLong(int[] nums) {
//		int max = nums[0];
//		int len = 1;
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] > max) {
//				len += 1;
//				max = nums[i];
//			} else if (getFrontNum(i, nums) == len) {
//				len += 1;
//				max = nums[i];
//			}
//		}
//		return len;
//	}
//
//	private int getFrontNum(int i, int[] arr) {
//		int count = 0;
//		int cmp = arr[i];
//		for (int j = i; j >= 0; j--) {
//			if (arr[j] < cmp) {
//				cmp = arr[j];
//				count++;
//			}
//		}
//		return count;
//	}

	public int getLong2(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int result = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			if (result < dp[i])
				result = dp[i];
		}
		return result;
	}

}
