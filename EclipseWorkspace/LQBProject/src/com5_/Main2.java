package com5_;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String next = scanner.next();
			char[] cArr = next.toCharArray();
			int len = cArr.length;
			boolean[][] dp = new boolean[len][len];
			int count = 0;
			int tempj = 0;
			while (tempj < len) {
				int i = 0;
				int j = tempj;
				while (i < len && j < len) {
					if (i == j) {
						dp[i][j] = true;
						count++;
					} else if (i == j - 1) {
						if (cArr[i] == cArr[j]) {
							dp[i][j] = true;
							count++;
						}
					} else if (i < j - 1) {
						if (cArr[i] == cArr[j] && dp[i + 1][j - 1]) {
							dp[i][j] = true;
							count++;
						}
					}
					i++;
					j++;
				}
				tempj++;
			}
			System.out.println(count);
		}
	}
}
