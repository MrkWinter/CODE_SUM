package com4_;

import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == -1)
				break;
			showFractal(n, false);
			System.out.println("-");
		}
	}

	private static void showFractal(int n, boolean b) {
		if (n == 1)
			System.out.println("X");
		if(n == 2) {
			System.out.println();
		}
	}
}
