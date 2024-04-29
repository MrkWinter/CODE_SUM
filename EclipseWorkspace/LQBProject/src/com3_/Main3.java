package com3_;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String next = scanner.next();
			String[] split = next.split("\\.");
			char[] arr = split[1].toCharArray();
			BigDecimal result = new BigDecimal("0");
			int p = -1;
			for (int i = 0; i < arr.length; i++) {
				result = result.add(new BigDecimal(Double.valueOf(arr[i] + "") * Math.pow(8, -(i + 1))));
			}
			int n = next.length() - 2;
			System.out.print(next + " [8] = ");
			System.out.printf("%." + 3 * n + 2 + "s [10]\n", result.toString());
		}
	}
}
