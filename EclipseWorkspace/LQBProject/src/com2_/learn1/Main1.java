package com2_.learn1;

import java.util.Scanner;

public class Main1 {
	private static int[] haabMonth = { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 5 };
	private static String[] haabMonthStr = { "pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax",
			"zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu", "uayet" };
	private static int tzoLkinMonth = 13;
	private static String[] tzolkinMonthArr = { "imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat",
			"muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String next = scanner.next();
			int haabDay = Integer.valueOf( next.substring(0, next.length()-1));
			String haabMonth = scanner.next();
			int haabYear = scanner.nextInt();
			int haabSumDay = gethaabDay(haabYear, haabMonth, haabDay);
			String result = getTzolkinData(haabSumDay);
			System.out.println(result);
		}

	}

	private static String getTzolkinData(int haabSumDay) {
		int tzolkinDay = 0;
		int tzolkinDayName = 0;
		int tzolkinYear = 0;
		tzolkinYear += haabSumDay / 260;
		haabSumDay %= 260;
		tzolkinDay = (haabSumDay - 1) % 13 + 1;
		for (int i = 0; i < haabSumDay / 13; i++) {
			tzolkinDayName = (tzolkinDayName + 12) % 20 + 1;
		}
		tzolkinDayName = (tzolkinDayName + haabSumDay % 13 - 1) % 20 + 1;
		return tzolkinDay + " " + tzolkinMonthArr[tzolkinDayName - 1] + " " + tzolkinYear;
	}

	private static int gethaabDay(int haabYear, String haabMonth, int haabDay) {
		int sumDay = 0;
		sumDay += haabYear * 365;
		int i = 0;
		for (; i < haabMonthStr.length; i++) {
			if (haabMonthStr[i].equals(haabMonth))
				break;
		}
		sumDay += i * 20;
		sumDay += haabDay + 1;
		return sumDay;
	}
}
