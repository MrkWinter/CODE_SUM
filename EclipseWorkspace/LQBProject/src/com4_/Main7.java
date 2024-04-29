package com4_;

import java.util.Scanner;

public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int time = scanner.nextInt();
			for (int i = 0; i < time; i++) {
				n = getResu(n);
			}
			System.out.println(n);
		}
	}

	private static int getResu(int n) {
		if(n == 1) {
			return 1;
		}else {
			return ((getResu(n-1)+1)%n)+1;
		}
	}
}
