package com.learn9;

import java.util.Scanner;

public class Test4 {
	public static String[] weekdays = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	public static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	public static int[] monthArr1 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static int[] monthArr2 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(getweek(1752, 9, 14));
		while (true) {
			int month = scanner.nextInt();
			int day = scanner.nextInt();
			int year = scanner.nextInt();
			if (month == 0 && day == 0 && year == 0)
				break;
			int c = checkData(year, month, day);
			if (c == 0) {
				System.out.println(month + "/" + day + "/" + year + " is an invalid date.");
				continue;
			}
			int weekday = getweek(1752, 9, 14) - 1;
			if (c == -1) {
				int totalDay = getTotalDay(year, month, day);
				weekday = ((weekday - totalDay - 1) % 7 + 7) % 7 + 1;
			} else if (c == 1) {
				weekday = getweek(year, month, day);
			}
			System.out.println(months[month - 1] + " " + day + ", " + year + " is a " + weekdays[weekday - 1]);
		}
	}

	private static int getTotalDay(int year, int month, int day) {
		// TO 1752,9,2
		// To 1752,8
		if (year == 1752 && month == 9)
			return 2 - day;
		int totalDay = 0;
		totalDay += (monthArr2[month - 1] - day);
		if (month == 2 && year % 4 == 0)
			totalDay += 1;
		month += 1;
		if (month == 13) {
			year += 1;
			month = 1;
		}
		totalDay += 2;
		for (int i = year; i <= 1752; i++) {
			int j = month;
			for (; j <= 12; j++) {
				if (year == 1752 && j == 9)
					break;
				totalDay += monthArr1[j - 1];
				if (j == 2 && year % 4 == 0)
					totalDay += 1;

			}
			j = 1;
		}
		return totalDay;
	}

	private static int getweek(int year, int month, int day) {
		// TODO Auto-generated method stub
		return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 + 1;
	}

	private static int checkData(int year, int month, int day) {
		// TODO Auto-generated method stub
		if (month <= 0 || month >= 13 || year <= 0)
			return 0;
		int result = 0;
		int isLow = compare(year, month, day, 1752, 9, 2);
		int isHight = compare(year, month, day, 1752, 9, 2);
		if (isLow <= 0) {
			int topDay = monthArr1[month - 1];
			if (year % 4 == 0 && month == 2)
				topDay++;
			if (day >= 1 && day <= topDay)
				result = -1;
		} else if (isHight >= 0) {
			int topDay = monthArr2[month - 1];
			if (month == 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0))
				topDay++;
			if (day >= 1 && day <= topDay)
				result = 1;
		}
		return result;
	}

	private static int compare(int i, int j, int k, int year, int month, int day) {
		if (i != year)
			return i - year;
		if (j != month)
			return j - month;
		if (k != day)
			return k - day;
		return 0;
	}
}
//11 15 1997
//9 2 1752
//9 14 1752
//4 33 1997
//0 0 0

//November 15, 1997 is a Saturday
//September 2, 1752 is a Wednesday
//September 14, 1752 is a Thursday
//4/33/1997 is an invalid date.

// 两个日期
//LocalDate date1 = LocalDate.of(2022, 1, 1);
//LocalDate date2 = LocalDate.of(2022, 1, 10);
//
//// 计算日期差值
//long daysDiff = ChronoUnit.DAYS.between(date1, date2);
//System.out.println("日期相差天数：" + daysDiff);
