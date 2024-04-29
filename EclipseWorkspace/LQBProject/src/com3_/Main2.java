package com3_;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String num1 = scanner.next();
			String num2 = scanner.next();
			BigDecimal result = new BigDecimal("0");
			BigDecimal n1 = new BigDecimal(num1);
			BigDecimal n2 = new BigDecimal(num2);
			result = n1.multiply(n2);
			System.out.println(result.toString());
		}
	}
}
