package com.learn2;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int c = scanner.nextInt();
		for (int x = 0; x < c; x++) {
			int num = 0;
			while (true) {
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				if (n == 0 && m == 0) {
					break;
				}
				int count = 0;
				for (int i = 1; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						int ab = i * j;
						if ((i * i + j * j + m) % ab == 0) {
							count++;
						}
					}
				}
				num += 1;
				System.out.println("Case " + num + ": " + count);
			}
		}
	}
}
