package com.learn3;

import java.util.Scanner;

public class Test8 {
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
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			boolean flag = false;
			for (int i = 2;; i++) {
				if (!arr[i])
					continue;
				if (i > n / 2)
					break;
				if (arr[n - i]) {
					flag = true;
				}
			}
			System.out.println(flag ? "yes" : "no");
		}
	}
}
