package com8_;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String num = scanner.next();
		BigDecimal n = new BigDecimal(num);
		BigDecimal mul = new BigDecimal("1");
		int i = 1;
		int result = -1;
		while (true) {
			BigDecimal count = new BigDecimal("0");
			int temp = i;
			while (temp != 0) {
				count = count.add(new BigDecimal(temp / 5));
				temp /= 5;
			}
			if (count.compareTo(n) == 0) {
				result = i;
				break;
			} else if (count.compareTo(n) > 0) {
				break;
			}
			i++;
		}
		System.out.println(result);
	}
}
