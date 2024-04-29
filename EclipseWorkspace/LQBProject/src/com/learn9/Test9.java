package com.learn9;

import java.util.Scanner;

public class Test9 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String next = scanner.next();
			if (next.charAt(0) == '0')
				break;
			StringBuilder dateStr = new StringBuilder(next);
			boolean flag = true;
			for (int i = 0; i < dateStr.length() - 7; i++) {
				char begin = dateStr.charAt(i);
				if (begin != '1' && begin != '2')
					continue;
				String year = dateStr.substring(i, i + 4);
				String month = dateStr.substring(i + 4, i + 6);
				String day = dateStr.substring(i + 6, i + 8);
				if (checkDate(year, month, day)) {
					System.out.println(year + "-" + month + "-" + day);
					flag = false;
				}
			}
			if (flag)
				System.out.println("None");
			System.out.println();
		}
	}

	private static boolean checkDate(String year, String month, String day) {
		Integer y = Integer.valueOf(year);
		if (y < 1958 || y > 2008)
			return false;
		Integer m = Integer.valueOf(month);
		if (m <= 0 || m >= 13)
			return false;
		Integer d = Integer.valueOf(day);
		if (d <= 0 || d >= 32)
			return false;
		int topMonthDay = months[m - 1];
		if (m == 2 && (y % 4 == 0 && y % 100 != 0 || y % 400 == 0))
			topMonthDay += 1;
		if (d <= topMonthDay)
			return true;
		else
			return false;
	}
}
