package com.learn8;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int d = 1;
		while (true) {
			String pattern = scanner.next();
			if (pattern.equals("end."))
				break;
			int indexOf = pattern.indexOf("?");
			String subA = pattern.substring(0, indexOf);
			String subB = pattern.substring(indexOf + 1);
			int[] next = getNext(subA);
			int lenB = subB.length();
			int lenA = subA.length();
			int n = scanner.nextInt();
			scanner.nextLine();
			System.out.println("case" + d + " :");
			for (int i = 0; i < n; i++) {
				String text = scanner.nextLine();
				int ki = 0;
				while (ki < text.length()) {
					ki = KMP(text, subA, next, ki);
					if (ki == -1) {
						System.out.println("none");
						break;
					}
					String substring = text.substring(ki + lenA + 1, ki + 1 + lenB + lenA);
					if (subB.equals(substring)) {
						System.out.println(subA + text.charAt(ki+lenA) + subB);
						break;
					}
					ki += 1;
				}
			}
			System.out.println();
d++;
		}

	}

	public static int KMP(String text, String pattern, int[] next, int i) {
		if (next == null)
			next = getNext(pattern);
//		int i = 0; // 匹配串 下标
		int j = 0; // 模式串 下标
		int tLen = text.length();
		int pLen = pattern.length();
		while (i - j <= tLen - pLen && j < pLen) {
			if (j < 0 || text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return j == pLen ? i - j : -1;
	}

	private static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];
		char[] pArr = pattern.toCharArray();
		int i = 0;
		int n = -1;
		next[0] = -1;
		while (i < next.length - 1) {
			if (n < 0 || pArr[i] == pArr[n]) {
				next[++i] = ++n;
			} else {
				n = next[n];
			}
		}
		return next;
	}
}
