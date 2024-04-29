package com.learn7;

import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String ordstr = scanner.next();
			String rodstr = scanner.next();
			int index = 0;
			boolean flag = false;
			for (int i = 0; i < rodstr.length(); i++) {
				if (rodstr.charAt(i) != ordstr.charAt(index))
					continue;
				if (index == ordstr.length() - 1) {
					flag = true;
					break;
				}
				index += 1;
			}
			if (flag) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
//person compression
//VERDI vivaVittorioEmanueleReDiItalia