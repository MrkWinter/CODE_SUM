package com.dataStract.unit2._06dp;

public class Test3 {
	public static void main(String[] args) {
		int lsc = lscString("ccabcde", "cdabcdeb");
		System.out.println(lsc);

	}

	public static int lsc(int[] nums1, int[] nums2) {
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[nums1.length][nums2.length];
	}

	public static int lsc(int[] nums1, int i, int[] nums2, int j) {
		if (i == 0 || j == 0)
			return 0;
		if (nums1[i] == nums2[j])
			return 1 + lsc(nums1, i - 1, nums2, j - 2);
		return Math.max(lsc(nums1, i - 1, nums2, j), lsc(nums1, i, nums2, j - 1));
	}

	public static int lsc(String s1, String s2) {
		char[] cArr1 = s1.toCharArray();
		char[] cArr2 = s2.toCharArray();
		int[][] dp = new int[cArr1.length + 1][cArr2.length + 1];
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (cArr1[i - 1] == cArr2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (max < dp[i][j]) {
						max = dp[i][j];
					}
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

	public static int lscString(String s1, String s2) {
		char[] cArr1 = null;
		char[] cArr2 = null;
		if (s1.length() > s2.length()) {
			cArr1 = s1.toCharArray();
			cArr2 = s2.toCharArray();
		} else {
			cArr1 = s2.toCharArray();
			cArr2 = s1.toCharArray();
		}
		int[][] dp = new int[1][cArr2.length + 1];
		int max = 0;
		for (int i = 1; i < cArr1.length + 1; i++) {
			int cur = 0;
			for (int j = 1; j < cArr2.length + 1; j++) {
				int leftTop = cur;
				cur = dp[0][j];
				if (cArr1[i - 1] == cArr2[j - 1]) {
					dp[0][j] = leftTop + 1;
					if (max < dp[0][j]) {
						max = dp[0][j];
					}
				} else {
					dp[0][j] = 0;
				}
			}
		}
		return max;
	}
}
