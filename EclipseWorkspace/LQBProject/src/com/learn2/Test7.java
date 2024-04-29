package com.learn2;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double x1 = scanner.nextDouble();
			double y1 = scanner.nextDouble();
			double x2 = scanner.nextDouble();
			double y2 = scanner.nextDouble();
			double x3 = scanner.nextDouble();
			double y3 = scanner.nextDouble();
			double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			double b = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
			double c = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
			double p = (a + b + c) / 2;
			double r = a * b * c / (4 * Math.sqrt(p * (p - a) * (p - b) * (p - c)));
			double result = 2 *Math.PI * r;
			System.out.printf("%.2f\n",result);
		}
	}
}
