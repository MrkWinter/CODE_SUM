package com2_.learn1;

import java.util.Scanner;

public class Main6 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int year = scanner.nextInt();
			int month = scanner.nextInt();
			int day = scanner.nextInt();
			if(year == 0 && month == 0 && day ==0)
				break;
			int total = 0;
			for (int i = 1; i < month; i++) {
				total += months[i-1];
			}
			if (month > 2 && isLoop(year))
				total += 1;
			total += day;
			System.out.println(total);
		}
	}

	public static boolean isLoop(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		return false;
	}
}
