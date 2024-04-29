package com5_;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] arr = new int[n + 1];
			int[][] dp = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();
			}
			int tempi = 0;
			int tempj = 1;
			while (tempi < n && tempj < n) {
				int i = tempi;
				int j = tempj;
				while (i < n && j < n) {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						min = Math.min(min, dp[i][k] + dp[k+1][j] + arr[i] * arr[k+1] * arr[j+1]);
					}
					dp[i][j] = min;
					i++;
					j++;
				}
				tempj++;
			}
			System.out.println(dp[0][n - 1]);
		}
	}
}
