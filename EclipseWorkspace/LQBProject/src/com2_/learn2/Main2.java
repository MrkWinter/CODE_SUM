package com2_.learn2;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			char[] num1 = new StringBuilder(scanner.next()).reverse().toString().toCharArray();
			char[] num2 = new StringBuilder(scanner.next()).reverse().toString().toCharArray();
			if (num1[0] == '0' && num2[0] == '0') {
				break;
			}
			int count = 0;
			int nextJ = 0;
			int num1Len = num1.length;
			int num2Len = num2.length;
			for (int i = 0; i < Math.max(num1Len, num2Len); i++) {
				int n1 = 0;
				if (i < num1Len)
					n1 = Integer.valueOf(num1[i] + "");
				int n2 = 0;
				if (i < num2Len)
					n2 = Integer.valueOf(num2[i] + "");
				int curRes = n1 + n2 + nextJ;
				if (curRes >= 10) {
					nextJ = 1;
					count += 1;
				} else {
					nextJ = 0;
				}
			}
			if (count == 1) {
				System.out.println(count + " carry operation.");
			} else if (count > 1) {
				System.out.println(count + " carry operations.");
			} else {
				System.out.println("No carry operation.");
			}
		}
	}
}