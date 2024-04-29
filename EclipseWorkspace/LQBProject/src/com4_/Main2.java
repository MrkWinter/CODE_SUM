package com4_;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String[] strArr = new String[1001];
//		StringBuilder sb = new StringBuilder("1");
//		for (int i = 0; i < strArr.length; i++) {
//			strArr[i] = sb.toString();
//			int len = sb.length();
//			StringBuilder temp = new StringBuilder();
//			for (int j = 0; j < len; j++) {
//				if (sb.charAt(j) == '0') {
//					temp.append("10");
//				} else {
//					temp.append("01");
//				}
//			}
//			sb = temp;
//		}

		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			String string = getString(n);
			int count = getCount(string);
			System.out.println(count);

		}
	}

	private static int getCount(String next) {
		char[] arr = next.toCharArray();
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == '0' && arr[i] == arr[i - 1]) {
				count += 1;
				i += 2;
			}
		}
		return count;
	}

	private static String getString(int n) {
		StringBuilder sb = new StringBuilder("1");
		for (int i = 0; i < n; i++) {
			int len = sb.length();
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < len; j++) {
				if (sb.charAt(j) == '0') {
					temp.append("10");
				} else {
					temp.append("01");
				}
			}
			sb = temp;
		}
		return sb.toString();
	}
}
