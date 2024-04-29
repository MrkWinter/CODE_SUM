package com.learn9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class Test7 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] weeks = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		while (true) {
			int day = scanner.nextInt();
			if (day == -1)
				break;
			int[] date = getDateByAdd(2000, 1, 1, day);
			int week = getWeek(date[0], date[1], date[2]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String format = LocalDate.of(date[0], date[1], date[2]).format(formatter);
			System.out.println(format + " " + weeks[week - 1]);
		}
	}

	private static int getWeek(int year, int month, int day) {
		if (month == 1 || month == 2) {
			month += 12;
			year -= 1;
		}
		return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 + 1;
	}

	private static int[] getDateByAdd(int year, int month, int day, int n) {
		int[] date = new int[3];
		int curMonthDay = 0;
		curMonthDay = months[month - 1];
		if (month == 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			curMonthDay += 1;
		}
		while (n / curMonthDay > 0) {
			n -= curMonthDay;
			month += 1;
			if (month >= 13) {
				year += 1;
				month = 1;
			}
			curMonthDay = months[month - 1];
			if (month == 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
				curMonthDay += 1;
			}
		}
		int lDay = months[month - 1] - day;
		if (month == 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			lDay++;
		}
		if (lDay >= n) {
			day += n;
		} else {
			month += 1;
			if (month >= 13) {
				year += 1;
				month = 1;
			}
			day = n - lDay;
		}
		date[0] = year;
		date[1] = month;
		date[2] = day;
		return date;
	}
}
