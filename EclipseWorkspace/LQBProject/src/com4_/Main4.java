package com4_;

import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int result = getDivNum(n);
			System.out.println(result);
		}
	}

	private static int getDivNum(int n) {
		return getDiv(n, 0, 6);
	}

	private static int getDiv(int n, int sum, int tx) {
		int count = 0;
		for (int i = tx; i >= 1; i--) {
			if (sum + i == n) {
				count++;
			} else if (sum + i > n) {
				continue;
			} else {
				count += getDiv(n, sum+i,i);
			}
		}
		return count;
	}
}
