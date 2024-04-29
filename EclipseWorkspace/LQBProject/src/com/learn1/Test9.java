package com.learn1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		double D = scanner.nextDouble();
//		double V = scanner.nextDouble();
//		double folor = Math.pow(D, 3) - 6 * V / Math.PI;
//		System.out.printf("%.3f",Math.pow(folor, 1.0/3));

		Scanner scanner = new Scanner(System.in);
		double D = 1.0;
		double V = 1.0;
		double folor = 1.0;
		double result = 1.0;
		while (true) {
			D = scanner.nextDouble();
			V = scanner.nextDouble();
			if (D == 0 && V == 0)
				break;
			folor = Math.pow(D, 3) - 6 * V / Math.PI;
			result = Math.pow(folor, 1.0 / 3);
			result = new BigDecimal(result).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println(result);
		}
	}
}
