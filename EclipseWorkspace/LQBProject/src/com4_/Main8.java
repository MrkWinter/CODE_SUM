package com4_;

import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[10000001];
		arr[3] = 1;
		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i/2] + arr[(i+1)/2];
		}
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int result = arr[n];
			System.out.println(result);
		}
	}

	private static int getResult(int n) {
		if (n == 3)
			return 1;
		if (n < 3)
			return 0;
		int even = getResult(n / 2);
		int agv = getResult((n + 1) / 2);
		return even + agv;
	}
}
