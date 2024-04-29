package com.learn8;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String next = scanner.next();
			if (next.equals("end"))
				break;
			String pattern = scanner.next();
			int index = KMP(next, pattern);
			if (index != -1) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	// ∆”Àÿ∆•≈‰∑®
//	private static int getString(String str, String pattern) {
//		int cur = 0;
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == pattern.charAt(cur))
//				cur += 1;
//			else {
//				i = i - cur;
//				cur = 0;
//			}
//			if (cur == pattern.length()) {
//				return i - cur + 1;
//			}
//		}
//		return -1;
//	}

	private static int KMP(String text, String pattern) {
		char[] tsArr = text.toCharArray();
		char[] psArr = pattern.toCharArray();
		int[] next = getNext(pattern);
		int tlen = tsArr.length;
		int plen = psArr.length;
		int i = 0;
		int j = 0;
		if (tlen < plen || tlen <= 0 || plen <= 0)
			return -1;
		while (i - j <= tlen - plen && j < plen) {
			if (j < 0 || tsArr[i] == psArr[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return j == plen ? i - j : -1;
	}

	public static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];
		char[] pArr = pattern.toCharArray();
		int i = 0;
		int n = -1;
		next[0] = -1;
		while(i < next.length-1) {
			if(n<0 || pArr[i] == pArr[n]) {
				next[++i] = ++n;
			} else {
				n = next[n];
			}
		}
		return next;
	}
}
