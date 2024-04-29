package com3_;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			BigDecimal result = new BigDecimal("0");
			for (int i = 0; i < n; i++) {
				BigDecimal curNum = new BigDecimal(scanner.next().substring(1).replace(",", ""));
				result= result.add(curNum);
			}
			DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
			String format = decimalFormat.format(result);
			System.out.println("$" + format);
		}
	}
}
