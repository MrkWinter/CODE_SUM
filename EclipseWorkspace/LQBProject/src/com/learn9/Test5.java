package com.learn9;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		int[] arr = {9,6,5,5,5,5,6};
		Scanner scanner = new Scanner(System.in);
		int n  =scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int year = scanner.nextInt();
			int week = getWeek(year,5,1);
			System.out.println(arr[week-1]);
		}
	}
	
	public static int getWeek(int year,int month,int day) {
		if(month == 1 || month == 2) {
			month+=12;
			year--;
		}
		return (day+ 2*month + 3*(month+1)/5 + year + year/4 - year /100 + year/400)%7 + 1;
	}
}
