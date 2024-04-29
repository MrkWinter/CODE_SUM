package com.learn2;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double[] resultArr = new double[100000];
		double len = 0;
		for (int i = 1; i < resultArr.length; i++) {
			resultArr[i] = (len += 1.0 / (i * 2.0));
		}
		System.out.println("# Cards  Overhang");
		while (scanner.hasNext()) {
			int i = scanner.nextInt();
			System.out.printf("%5d     ", i);
			System.out.printf("%.3f\n", resultArr[i]);
		}
	}
}
