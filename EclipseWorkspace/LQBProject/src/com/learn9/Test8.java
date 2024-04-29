package com.learn9;

import java.util.ArrayList;
import java.util.Scanner;

public class Test8 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		String[] split = str.split("/");
		String d1 = split[0];
		String d2 = split[1];
		String d3 = split[2];
		String year = " ";
		ArrayList<String> result = new ArrayList<String>();
		if ((year = checkDate(d1, d2, d3)) != null) {
			result.add(year + "-" + d2 + "-" + d3);
		}
		if ((year = checkDate(d3, d1, d2)) != null) {
			result.add(year + "-" + d1 + "-" + d2);
		}
		if ((year = checkDate(d3, d2, d1)) != null) {
			result.add(year + "-" + d2 + "-" + d1);
		}
		result.sort((s1, s2) -> s1.compareTo(s2));
		for (String s : result)
			System.out.println(s);
	}

	private static String checkDate(String year, String month, String day) {
		Integer y = Integer.valueOf(year);
		Integer m = Integer.valueOf(month);
		Integer d = Integer.valueOf(day);
		if (m <= 0 || m >= 13)
			return null;
		if (d <= 0 || d >= 32)
			return null;
		if (y < 60) {
			y = Integer.valueOf("20" + year);
		} else {
			y = Integer.valueOf("19" + year);
		}
		int topMonthDay = months[m - 1];
		if (m == 2 && (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)) {
			topMonthDay += 1;
		}
		if (d <= topMonthDay)
			return y.toString();
		else
			return null;
	}
}
