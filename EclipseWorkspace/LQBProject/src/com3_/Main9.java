package com3_;

import java.util.ArrayList;
import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String num1 = scanner.next();
			String num2 = scanner.next();
			int len1 = num1.length();
			int len2 = num2.length();
			int mLen = Math.max(len1, len2);
			ArrayList<Integer> list = new ArrayList<Integer>(mLen);
			int carry = 0;
			for (int j = 0; j < mLen; j++) {
				int n1 = j < len1 ? num1.charAt(j) - '0' : 0;
				int n2 = j < len2 ? num2.charAt(j) - '0' : 0;
				int sum = n1 + n2 + carry;
				if (sum >= 10) {
					carry = 1;
					list.add(sum % 10);
				} else {
					carry = 0;
					list.add(sum);
				}
			}
			if (carry == 1)
				list.add(carry);
			StringBuilder result = new StringBuilder();
			boolean flag = true;
			for (int j : list) {
				if (flag && j == 0)
					continue;
				result.append(j);
				flag = false;

			}
			System.out.println(result.toString());
		}
	}
}
