package com.learn9;

public class Test3 {
	private static int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 30, 31, 31, 31, 31 };

	public static void main(String[] args) {

		int day = getDays(2024, 3, 7, 2025, 3, 8);
		System.out.println(day);
//		int week = getWeek(2024, 3, 27);
//		System.out.println(week);
	}

	public static int getWeek(int year, int month, int day) {
		if (month == 1 || month == 2) {
			month += 12;
			year--;
		}
		return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 + 1;
	}

	public static int getDay(int fYear, int fMonth, int fDay, int tYear, int tMonth, int tDay) {
		int resultDay = 0;
		int j = fMonth - 1;
		int k = fDay;
		for (int i = fYear; i <= tYear; i++) {
			for (; j <= 11; j++) {
				int monthsDay = months[j];
				if (j == 1 && (i % 4 == 0 && i % 100 != 0 || i % 400 == 0))
					monthsDay += 1;
				for (; k <= monthsDay; k++) {
					if (i == tYear && j == tMonth - 1 && k == tDay) {
						return resultDay;
					}
					resultDay++;
				}
				k = 1;
			}
			j = 0;
		}
		return 0;
	}

	public static int getDays(int fYear, int fMonth, int fDay, int tYear, int tMonth, int tDay) {
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (fMonth-- == tMonth--   && fYear == tYear)
			return tDay - fDay;
		int sumDay = 0;
		sumDay += (months[fMonth] - fDay + tDay); //计算两端天数
		if (fMonth == 1 && (fYear % 4 == 0 && fYear % 100 != 0 || fYear % 400 == 0))
			sumDay += 1;
		fMonth = fMonth + 1;
		if (fMonth > 11) {
			fMonth = 0;
			fYear += 1;
		}
		tMonth = tMonth - 1;
		if (tMonth < 0) {
			tMonth = 11;
			tYear -= 1;
		}
		// 计算每月数
		int j= fMonth;
		for (int i = fYear; i <= tYear; i++) {
			for (; j <= 11; j++) {
				if(j == tMonth+1 && i == tYear)
					break;
				sumDay += months[j];
				if (j == 1 && (i % 4 == 0 && i % 100 != 0 || i % 400 == 0))
					sumDay += 1;
			}
			j = 0;
		}
		return sumDay;
	}
}
