package com4_;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		BigDecimal[] countZeros = countZeros(1000);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(countZeros[n].toString());
		}
	}

	public static BigDecimal[] countZeros(int n) {
		BigDecimal[] dp = new BigDecimal[n + 1];
		dp[0] = new BigDecimal("0");
		dp[1] = new BigDecimal("0");
		dp[2] = new BigDecimal("1");
		BigDecimal mul = new BigDecimal("2");
		BigDecimal d = new BigDecimal("1");
		BigDecimal e = new BigDecimal("-1");
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				dp[i] = dp[i - 1].multiply(mul).add(d);
			} else {
				dp[i] = dp[i - 1].multiply(mul).add(e);
			}
		}
		return dp;
	}
}
