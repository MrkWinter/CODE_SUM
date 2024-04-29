package com.dataStract.unit2._06dp;

import java.util.Arrays;

public class Test4 {
	public static void main(String[] args) {
		int[] value = { 2, 3, 5, 7, 8 };
		int[] weight = { 3, 4, 5, 7, 8 };
		int _01bag = _01bag4(value, weight, 20);
		System.out.println(_01bag);

	}

	public static int _01bag(int[] value, int[] weight, int w) {
		int row = value.length;
		int col = w;
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (weight[i - 1] <= j) {
					dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);

				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[row][col];
	}

	public static int _01bag2(int[] value, int[] weight, int w) {
		int row = value.length;
		int col = w;
		int[] dp = new int[col + 1];
		for (int i = 1; i < row + 1; i++) {
			for (int j = w; j >= weight[i - 1]; j--) {
				dp[j] = Math.max(value[i - 1] + dp[j - weight[i - 1]], dp[j]);
			}
		}
		return dp[col];
	}

	public static int _01bag3(int[] value, int[] weight, int w) {
		int row = value.length;
		int col = w;
		int[][] dp = new int[row + 1][col + 1];
//		for (int[] arr : dp) {
//			Arrays.fill(arr, -1);
//		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (weight[i - 1] <= j) {
					if (j - weight[i - 1] == 0 || dp[i - 1][j - weight[i - 1]] != 0)
						dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
					else
						dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[row][col];
	}
	public static int _01bag4(int[] value, int[] weight, int w) {
		int row = value.length;
		int col = w;
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = Integer.MIN_VALUE;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (weight[i - 1] <= j) {
					dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);

				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[row][col];
	}

}
