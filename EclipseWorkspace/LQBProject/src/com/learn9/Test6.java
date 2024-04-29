package com.learn9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Test6 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int fYear = scanner.nextInt();
			int fMonth = scanner.nextInt();
			int fDay = scanner.nextInt();
			int tYear = scanner.nextInt();
			int tMonth = scanner.nextInt();
			int tDay = scanner.nextInt();
			int difDay = getDiffDay(fYear, fMonth, fDay, tYear, tMonth, tDay);
			System.out.println(difDay);
		}
	}

	private static int getDiffDay(int fYear, int fMonth, int fDay, int tYear, int tMonth, int tDay) {
		// TODO Auto-generated method stub
		if (fYear == tYear && fMonth == tMonth)
			return tDay - fDay;
		int totalDay = 0;
		// 处理天
		totalDay += months[fMonth - 1] - fDay + tDay;
		// 闰年
		if (fMonth == 2 && (fYear % 4 == 0 && fYear % 100 != 0 || fYear % 400 == 0))
			totalDay += 1;
		if (++fMonth >= 13) {
			fYear += 1;
			fMonth = 1;
		}
		int j = fMonth;
		for (int i = fYear; i <= tYear; i++) {
			for (; j <= months.length; j++) {
				if (i == tYear && j == tMonth)
					break;
				totalDay += months[j - 1];
				if (j == 2 && (i % 4 == 0 && i % 100 != 0 || i % 400 == 0))
					totalDay += 1;
			}
			j = 1;
		}
		// 处理月和年
		return totalDay;
	}

	private static int getDiffDay2(int fYear, int fMonth, int fDay, int tYear, int tMonth, int tDay) {
		// TODO Auto-generated method stub
		// 两个日期
		LocalDate date1 = LocalDate.of(fYear, fMonth, fDay);
		LocalDate date2 = LocalDate.of(tYear, tMonth, tDay);

		// 计算日期差值
		long daysDiff = ChronoUnit.DAYS.between(date1, date2);
		return (int) daysDiff;
	}
}
