package com.learn4;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int len = scanner.nextInt();
			int toNum = scanner.nextInt();
			int[] arr = new int[len];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scanner.nextInt();
			}
			int minToLen = Integer.MAX_VALUE;
			int beginIndex = 0;
			int curSum = 0;
			for (int j = 0; j < arr.length; j++) {
				curSum += arr[j];
				while (curSum - arr[beginIndex] >= toNum) {
					curSum -= arr[beginIndex++];
				}
				if (curSum >= toNum) {
					if (j - beginIndex + 1 < minToLen)
						minToLen = j - beginIndex + 1;
				}
			}
			System.out.println(minToLen == Integer.MAX_VALUE ? 0:minToLen);
		}
	}
}
//2
//10 15
//5 1 3 5 10 7 4 9 2 8
//5 11
//1 2 3 4 5