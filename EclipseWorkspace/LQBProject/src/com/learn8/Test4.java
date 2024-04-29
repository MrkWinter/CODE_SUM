package com.learn8;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String pattern = scanner.next();
			String text = scanner.next();
			System.out.println(getNumByKMP(text,pattern));
		}
	}
//	1
//	AZA
//	AZAZAZA
	public static int getNumByKMP(String text, String pattern) {
		int[] next = getNext(pattern);
		int i = 0; // 匹配串 下标
		int j = 0; // 模式串 下标
		int tLen = text.length();
		int pLen = pattern.length();
		int count = 0;
		while (true) {
			while (i - j <= tLen - pLen && j < pLen) {
				if (j < 0 || text.charAt(i) == pattern.charAt(j)) {
					i++;
					j++;
				} else {
					j = next[j];
				}
			}
			i = j == pLen ? i - j + 1 : -1;
			j = 0;
			if(i == -1)
				break;
			count+=1;
		}
		return count;
	}

	private static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];
		char[] pArr = pattern.toCharArray();
		int i = 0;
		int n = -1;
		next[0] = -1;
		while(i< next.length-1) {
			if(n<0 || pArr[i] == pArr[n]) {
				next[++i] = ++n;
			} else  {
				n = next[n];
			}
		}
		return next;
	}
}
