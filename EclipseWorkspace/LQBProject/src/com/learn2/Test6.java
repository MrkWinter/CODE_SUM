package com.learn2;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("PERFECTION OUTPUT");
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int sum = 1;
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0)
					sum += i;
			}
			if (sum < n) {
				System.out.printf("%5d  DEFICIENT", n);
			} else if (sum > n) {
				System.out.printf("%5d  ABUNDANT", n);
			} else {
				System.out.printf("%5d  PERFECT", n);
			}
		}
		System.out.println("END OF OUTPUT");
	}
}
