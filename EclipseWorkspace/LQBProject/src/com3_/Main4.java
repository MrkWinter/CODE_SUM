package com3_;

import java.util.Scanner;

public class Main4 {
	public static String sxStr = "0123456789abcdefghij";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			char[] num1 = new StringBuilder(scanner.next()).reverse().toString().toCharArray();
			char[] num2 = new StringBuilder(scanner.next()).reverse().toString().toCharArray();
			int len1 = num1.length;
			int len2 = num2.length;
			char[] resultArr = new char[Math.max(len1, len2) + 1];
			int carry = 0;
			for (int i = 0; i < resultArr.length; i++) {
				int n1 = i < len1 ? sxStr.indexOf(num1[i]) : 0;
				int n2 = i < len2 ? sxStr.indexOf(num2[i]) : 0;
				int sum = n1 + n2 + carry;
				if (sum >= 20) {
					carry = 1;
					resultArr[i] = sxStr.charAt(sum % 20);
				} else {
					resultArr[i] = sxStr.charAt(sum);
					carry = 0;
				}
			}
			StringBuilder result = new StringBuilder();
			int len = resultArr.length;
			int begin = resultArr[len - 1] == '0' ? len - 2 : len - 1;
			for (int i = begin; i >= 0; i--) {
				result.append(resultArr[i]);
			}
			System.out.println(result.toString());
		}
	}
}
