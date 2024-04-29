package com5_;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String next = scanner.nextLine();
			if (next.charAt(0) == '0')
				break;
			String[] split = next.split(" ");
			int len = split.length;
			int[] arr = new int[len];
			for (int i = 0; i < len; i++) {
				arr[i] = Integer.valueOf(split[i]);
			}
			int max = Integer.MIN_VALUE;
			int[][] dp = new int[len][len];
			for (int i = 0; i < len; i++) {
				for (int j = i; j < len; j++) {
					if (i == j) {
						dp[i][j] = arr[i];
						max = Math.max(dp[i][j], max);
					} else {
						dp[j][i] = Math.min(dp[j - 1][i], arr[j]);
						dp[i][j] =	(j - i +1) * dp[j][i];
						max = Math.max(dp[i][j], max);
					}
				}
			}
			System.out.println(max);
		}
	}
}
