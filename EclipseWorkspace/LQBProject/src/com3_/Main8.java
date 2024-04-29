package com3_;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();

		BigDecimal b1 = new BigDecimal("1");
		BigDecimal b2 = new BigDecimal("1");
		BigDecimal temp = new BigDecimal("1");
		list.add("1");
		while (true) {
			int len = b1.toString().length();
			if (len >= 1000)
				break;
			list.add(b1.toString());
			temp = b1;
			b1 = b2.add(b1);
			b2 = temp;
		}
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(list.get(n-1));
		}
	}
}
