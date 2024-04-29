package com8_;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		char[] cArr = next.toCharArray();
		int[] countArr = new int[26];
		for (int i = 0; i < cArr.length; i++) {
			char temp = cArr[i];
			countArr[temp-'A']++;
		}
		int max = Arrays.stream(countArr).max().getAsInt();
		for (int i = 0; i < countArr.length; i++) {
			if(countArr[i] == max) {
				System.out.print((char)(i+'A'));
			}
		}
		System.out.println();
	}
}
