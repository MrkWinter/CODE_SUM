package com.learn3;

import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Çó
		boolean[] arr = new boolean[1_000_000];
		for (int i = 2; i < arr.length; i++) {
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				arr[i] = true;
		}
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			for (int i = 2;; i++) {
				if (!arr[i])
					continue;
				if (i > n / 2)
					break;
				if (arr[n - i]) {
					System.out.println(n + " = " + i + " + " + (n - i));
					break;
				}
			}
		}
	}
}
