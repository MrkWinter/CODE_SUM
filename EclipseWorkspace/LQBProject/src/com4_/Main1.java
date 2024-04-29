package com4_;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<BigDecimal> list = new ArrayList<>();
		BigDecimal b1 = new BigDecimal("1");
		BigDecimal b2 = new BigDecimal("1");
		BigDecimal temp = new BigDecimal("1");
		list.add(b2);
		while (true) {
			int len = b1.toString().length();
			if (len >= 1000)
				break;
			list.add(b1);
			temp = b1;
			b1 = b2.add(b1);
			b2 = temp;
		}
		while (true) {
			String num1 = scanner.next();
			String num2 = scanner.next();
			if(num1.charAt(0) == '0' && num2.charAt(0) == '0')
				break;
			BigDecimal bn1 = new BigDecimal(num1);
			BigDecimal bn2 = new BigDecimal(num2);
			int count = 0;
			int i = 0;
			while (true) {
				if (bn1.compareTo(list.get(i)) <= 0) {
					break;
				}
				i++;
			}
			while (true) {
				if (bn2.compareTo(list.get(i)) < 0)
					break;
				i++;
				count++;
			}
			System.out.println(count);
		}
	}
}
