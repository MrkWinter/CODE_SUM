package com3_;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;

public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Object[] arr = new Object[1000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new HashSet<String>();
		}
		BigDecimal b1 = new BigDecimal("1");
		BigDecimal b2 = new BigDecimal("1");
		BigDecimal temp = new BigDecimal("1");
		while(true) {
			int len = b1.toString().length();
			if(len>=1000)
				break;
			((HashSet<String>)arr[len]).add(b1.toEngineeringString());
			temp = b1;
			b1 = b2.add(b1);
			b2 = temp;
		}
		while (scanner.hasNext()) {
			String next = scanner.next();
			int len = next.length();
			if (((HashSet<String>) arr[len]).contains(next)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
