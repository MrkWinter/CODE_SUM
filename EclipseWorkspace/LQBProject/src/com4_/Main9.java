package com4_;

import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String next = scanner.next();
			if (next.charAt(0) == '0')
				break;
			long result = getResult(next);
			System.out.println(result);
		}
	}

	private static long getResult(String next) {
		long result = 1;
		int begin = 0;
		for (int i = 1; i < next.length(); i++) {
			if (Integer.valueOf(next.substring(i - 1, i + 1)) < 27 || next.charAt(i) != '0') {
				if(i == next.length() -1) {
					result *= getB(i - begin+1);
					begin = i;
				}
				continue;
			}
			result *= getB(i - begin);
			begin = i;
		}
		return result;
	}

	public static long getB(int n) {
		long[] arr = new long[2];
		arr[0] = 1;
		arr[1] = 2;
		if (n <= 2)
			return arr[n - 1];
		for (int i = 3; i <= n; i++) {
			arr[(i+1) % 2] = arr[i % 2] + arr[(i + 1) % 2];
		}
		return arr[(n+1) % 2];
	}
}
