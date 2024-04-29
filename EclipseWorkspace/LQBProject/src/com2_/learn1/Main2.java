package com2_.learn1;

import java.util.Scanner;

public class Main2 {
	public static String[] datArr = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int year = scanner.nextInt();
			int toYear = year - 2009;
			int ti = 5;
			int di = 1;
			ti = (ti+toYear)%10;
			di = (di+toYear)%12;
			System.out.println(ti + datArr[di]);
		}
	}
}
