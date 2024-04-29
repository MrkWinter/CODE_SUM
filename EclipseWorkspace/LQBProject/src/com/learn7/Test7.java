package com.learn7;

import java.util.Scanner;

//public class Test7 {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			String next = scanner.next();
//			if (next.charAt(0) == '.')
//				break;
//			StringBuilder sb = new StringBuilder(next);
//			int result = -1;
//			char b = sb.charAt(0);
//			for (int i = 1; i < sb.length(); i++) {
//				if (b != sb.charAt(i))
//					continue;
//				String substring = sb.substring(0, i);
//				result = getPow(next, substring);
//				if (result != -1) {
//					break;
//				}
//			}
//			System.out.println(result);
//
//		}
//	}
//
//	private static int getPow(String next, String substring) {
//		int count = 0;
//		StringBuilder sb = new StringBuilder();
//		int i = 0;
//		while (sb.length() != next.length()) {
//			sb.append(substring);
//			count += 1;
//			for (; i < sb.length(); i++) {
//				if (next.charAt(i) != sb.charAt(i)) {
//					return -1;
//				}
//			}
//			// Æ¥Åä
//			if (sb.length() > next.length())
//				return -1;
//		}
//		return count;
//	}
//}


public class Test7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String next = scanner.next();
			if (next.charAt(0) == '.')
				break;
			char[] arr = next.toCharArray();
			int div = 1;
			int result = 1;
			while(++div<=arr.length) {
				if(arr.length % div == 0 && isRightDiv(arr,div)) {
					result = div;
				}
			}
			System.out.println(result);
		}
	}

	private static boolean isRightDiv(char[] arr, int div) {
		int pass = arr.length/div;
		for (int i = 0; i < pass; i++) {
			for (int j = 1; j < div; j++) {
				if(arr[i] != arr[i+pass*j])
					return false;
			}
		}
		return true;
	}
}








