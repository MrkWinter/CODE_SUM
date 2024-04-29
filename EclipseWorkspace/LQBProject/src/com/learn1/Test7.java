package com.learn1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(String.format("%.2f", 3.145));
		System.out.println(new DecimalFormat("#.00").format(3.145));
		double num = 3.145;
		BigDecimal bigDecimal = new BigDecimal(num);
		double doubleValue = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(doubleValue);

//		int n = scanner.nextInt();
//		int[] stones = new int[n];
//		for (int i = 0; i < stones.length; i++) {
//			stones[i] = scanner.nextInt();
//		}
//		int[] color = new int[n];
//		for (int i = 0; i < color.length; i++) {
//			color[i] = scanner.nextInt();
//		}
	}
}
