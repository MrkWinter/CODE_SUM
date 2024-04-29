package com2_.learn1;

import java.util.Scanner;

public class Main4 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int y = scanner.nextInt();
			int m = scanner.nextInt();
			int d = scanner.nextInt();
			int nu = scanner.nextInt();
			int count = 0;
			int j = y;
			int k = m;
			int l = d;
			for (; ; j++) {
				for (;k<=12 ; k++) {
					for (;l<30; l+=10) {
						if(getWeek(j,k,l) == 1) {
							count++;
							y = j;
							m = k;
							d = l;
							if(count == nu)
								break;
						}
					}
					l = 1;
					if(count==nu)
						break;
				}
				k = 1;
				if(count==nu)
					break;
			}
			System.out.println(y + " " + m + " " + d);
		}
	}

	private static int getWeek(int year, int month, int day) {
		if (month == 1 || month == 2) {
			month += 12;
			year -= 1;
		}
		return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 + 1;
	}
}
