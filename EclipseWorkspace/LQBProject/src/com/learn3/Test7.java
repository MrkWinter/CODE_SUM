package com.learn3;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Çó
		boolean[] arr = new boolean[32769];
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
			int count = 0;
			for (int i = 2;; i++) {
				if (!arr[i])
					continue;
				if (i > n / 2)
					break;
				if (arr[n - i]) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
