package com2_.learn1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main7 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String[] dataBArr = scanner.next().split("-");
			String[] dataEArr = scanner.next().split("-");
			int bYear = Integer.valueOf(dataBArr[0]);
			int bMonth = Integer.valueOf(dataBArr[1]);
			int bDay = Integer.valueOf(dataBArr[2]);
			int eYear = Integer.valueOf(dataEArr[0]);
			int eMonth = Integer.valueOf(dataEArr[1]);
			int eDay = Integer.valueOf(dataEArr[2]);
			LocalDate begin = LocalDate.of(bYear, bMonth, bDay);
			LocalDate end = LocalDate.of(eYear, eMonth, eDay);

			int between = (int) ChronoUnit.DAYS.between(begin, end);
			int week = getWeek(bYear, bMonth, bDay);
			if (week == 7)
				week = 0;
			if (between - (6 - week) < 0) {
				System.out.println(0);
			} else {
				System.out.println((between - (6 - week)) / 7 + 1);
			}
		}
	}

	public static boolean isLoop(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		return false;
	}

	private static int getWeek(int year, int month, int day) {
		if (month == 1 || month == 2) {
			month += 12;
			year -= 1;
		}
		return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 + 1;
	}
}
