package com.dataStract.unit2._06dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		int n = coin4(41, new int[] { 1, 5, 20, 25 });
		System.out.println(n);
	}

	// 暴力递归(自顶向下)
	public static int coin(int n) {
		if (n < 1)
			return Integer.MAX_VALUE;
		if (n == 25 || n == 20 || n == 5 || n == 1)
			return 1;
		int max = Math.min(coin(n - 25), coin(n - 20));
		int max2 = Math.min(coin(n - 5), coin(n - 1));
		return 1 + Math.min(max, max2);
	}

	// 记忆化搜索(自顶向下)
	public static int coin2(int n) {
		int[] dp = new int[Math.max(n + 1, 26)];
		dp[25] = dp[20] = dp[5] = dp[1] = 1;
		return coin2(n, dp);
	}

	public static int coin2(int n, int[] dp) {
		if (n < 1)
			return Integer.MAX_VALUE;
		if (dp[n] != 0) {
			return dp[n];
		}
		int max = Math.min(coin(n - 25), coin(n - 20));
		int max2 = Math.min(coin(n - 5), coin(n - 1));
		return dp[n] = 1 + Math.min(max, max2);
	}

	// 动态规划 (自底向上)
	public static int coin3(int n) {
		if (n < 1)
			return -1;
		int[] coin = new int[n + 1];
		HashMap<Integer, LinkedList<Integer>> hp = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < coin.length; i++) {
			hp.put(i, new LinkedList<Integer>());
		}
		for (int i = 1; i < coin.length; i++) {
			LinkedList<Integer> l = hp.get(i);
			if (i >= 1) {
				l.clear();
				coin[i] = coin[i - 1] + 1;
				l.addAll(hp.get(i - 1));
				l.add(1);
			}
			if (i >= 5 && coin[i - 5] + 1 < coin[i]) {
				coin[i] = Math.min(coin[i], coin[i - 5] + 1);
				l.clear();
				l.addAll(hp.get(i - 5));
				l.add(5);

			}
			if (i >= 20 && coin[i - 20] + 1 < coin[i]) {
				coin[i] = Math.min(coin[i], coin[i - 20] + 1);
				l.clear();
				l.addAll(hp.get(i - 20));
				l.add(20);
			}
			if (i >= 25 && coin[i - 25] + 1 < coin[i]) {
				coin[i] = Math.min(coin[i], coin[i - 25] + 1);
				// 选择 加入 错误
				l.clear();
				l.addAll(hp.get(i - 25));
				l.add(25);
			}
		}
		hp.get(n).stream().forEach(System.out::println);
		return coin[n];
	}

	public static int coin4(int n) {
		if (n < 1)
			return -1;
		int[] coin = new int[n + 1];
		int[] faces = new int[n + 1];
		for (int i = 1; i < coin.length; i++) {
			if (i >= 1) {
				coin[i] = coin[i - 1] + 1;
				faces[i] = 1;
			}
			if (i >= 5 && coin[i - 5] + 1 < coin[i]) {
				coin[i] = Math.min(coin[i], coin[i - 5] + 1);
				faces[i] = 5;
			}
			if (i >= 20 && coin[i - 20] + 1 < coin[i]) {
				coin[i] = Math.min(coin[i], coin[i - 20] + 1);
				faces[i] = 20;
			}
			if (i >= 25 && coin[i - 25] + 1 < coin[i]) {
				coin[i] = Math.min(coin[i], coin[i - 25] + 1);
				faces[i] = 25;
			}
		}
		System.out.println(faces[n] + "  " + faces[n - faces[n]] + "  " + faces[n - faces[n] - faces[n - faces[n]]]);
		return coin[n];
	}

	public static int coin4(int n, int[] faces) {
		if (n < 1 || faces == null || faces.length == 0)
			return -1;
		int[] coin = new int[n + 1];
		int[] result = new int[n + 1];
		for (int i = 1; i < coin.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < faces.length; j++) {
				if (i- faces[j] < 0)
					continue;
				if (coin[i - faces[j]] + 1 < min && coin[i - faces[j]] != -1) {
					min = coin[i - faces[j]] + 1;
					result[i] = faces[j];
				}
			}
			if (min == Integer.MAX_VALUE)
				coin[i] = -1;
			else
				coin[i] = min;
		}
		return coin[n];
	}
}
