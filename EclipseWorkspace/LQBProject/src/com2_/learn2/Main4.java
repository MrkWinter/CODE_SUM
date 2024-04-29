package com2_.learn2;

import java.util.Scanner;

public class Main4 {
	public static String sxArr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			int fsx = scanner.nextInt();
			int tsx = scanner.nextInt();
			String num = scanner.next();
			String result = getResult(num, fsx, tsx);
			System.out.println(fsx + " " + num);
			System.out.println(tsx);
			System.out.println(result);
		}
	}

	private static String getResult(String num, int fsx, int tsx) {
		char[] cArr = num.toCharArray();
		Long ordNum = 0l;
		int p = 0;
		for (int i = cArr.length - 1; i >= 0; i--) {
			ordNum += (long)(sxArr.indexOf(cArr[i]) * Math.pow(fsx, p));
			p++;
		}
		StringBuilder result = new StringBuilder();
		while (ordNum != 0) {
			result.append(sxArr.charAt((int) (ordNum % tsx)));
			ordNum /= tsx;
		}
		return result.reverse().toString();
	}
}