package com.learn8;

import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int times = scanner.nextInt();
			scanner.nextLine();
			for (int l = 0; l < times; l++) {
				String next = scanner.nextLine();
				String[] split = next.split(" ");
				for (int j = 0; j < split.length; j++) {
					String curStr = split[j];
					for (int k = curStr.length() - 1; k >= 0; k--) {
						System.out.print(curStr.charAt(k));
					}
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
}
