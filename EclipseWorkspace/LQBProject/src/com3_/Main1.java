package com3_;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			BigDecimal result = new BigDecimal("0");
			while (true) {
				String num = scanner.next();
				if(num.charAt(0) == '0')
					break;
				result = result.add(new BigDecimal(num));
			}
			System.out.println(result.toString());
		}
	}
}
