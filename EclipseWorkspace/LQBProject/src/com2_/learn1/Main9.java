package com2_.learn1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int bYear = scanner.nextInt();
			int bMonth = scanner.nextInt();
			int bDay = scanner.nextInt();
			int eYear = scanner.nextInt();
			int eMonth = scanner.nextInt();
			int eDay = scanner.nextInt();
			LocalDate begin = LocalDate.of(bYear, bMonth, bDay);
			LocalDate end = LocalDate.of(eYear, eMonth, eDay);
			int count = 0;
			while (!begin.isAfter(end)) {
				
				String dataStr = begin.toString();
				count += getCount(dataStr);
				begin = begin.plusDays(1);
			}
			System.out.println(count);
		}
	}

	private static int getCount(String dataStr) {
		char[] charArray = dataStr.toCharArray();
		int count = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '9')
				count++;
		}
		return count;
	}
}
