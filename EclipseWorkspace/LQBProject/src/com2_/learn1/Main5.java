package com2_.learn1;

import java.util.Scanner;

public class Main5 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		Integer year = Integer.valueOf(next);
		int count = 0;
		for (int i = 1; i <= 12; i++) {
			if(getWeek(year,i,13) == 5)
				count++;
		}
		System.out.println(count);
	}
	private static int getWeek(int year, int month, int day) {
		if (month == 1 || month == 2) {
			month += 12;
			year -= 1;
		}
		return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 + 1;
	}
}
