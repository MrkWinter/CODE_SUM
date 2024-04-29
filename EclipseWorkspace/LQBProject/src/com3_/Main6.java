package com3_;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int jx = scanner.nextInt();
			if (jx == 0)
				break;
			String num1 = scanner.next();
			String num2 = scanner.next();
			BigDecimal ordNum1 = getOrd(num1, jx);
			BigDecimal ordNum2 = getOrd(num2, jx);
			BigDecimal ordResult = ordNum1.remainder(ordNum2);
			String result = getResult(ordResult, jx);
			System.out.println(result);
		}
	}

	private static String getResult(BigDecimal ordResult, int jx) {
		StringBuilder result = new StringBuilder();
		BigDecimal mul = new BigDecimal(jx);
		while (ordResult.compareTo(BigDecimal.ZERO) != 0) {
			result.append(ordResult.remainder(mul).toString());
			ordResult = ordResult.divideToIntegralValue(mul);
		}
		return result.reverse().toString();
	}

	private static BigDecimal getOrd(String num1, int jx) {
		BigDecimal result = new BigDecimal("0");
		BigDecimal pow = new BigDecimal("1");
		BigDecimal mul = new BigDecimal(jx);
		int p = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			result = result.add(pow.multiply(new BigDecimal(num1.charAt(i) + "")));
			pow = pow.multiply(mul);
		}
		return result;
	}
}
