package com.learn7;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String next = scanner.next();
			int len = next.length();
			StringBuilder nextSb = new StringBuilder(next);
			for (int i = 0; i < len; i++) {
				boolean flag = true;
				StringBuilder sub = new StringBuilder(next.substring(0, i)).reverse();
				nextSb.append(sub);
				int nexLen = nextSb.length();
				for (int j = 0; j < nexLen / 2 + 1; j++) {
					if (nextSb.charAt(j) != nextSb.charAt(nexLen - j - 1)) {
						flag = false;
						break;
					}
				}
				nextSb = new StringBuilder(next);
				if (flag) {
					if (sub.length() == 0)
						System.out.println(next + " is a palindrome!");
					else
						System.out.println(sub);
					break;
				}
			}

		}
	}
}
//abcba
//abcdc
//abcba is a palindrome!
//ba