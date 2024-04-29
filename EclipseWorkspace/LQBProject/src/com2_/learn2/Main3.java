package com2_.learn2;

import java.util.Scanner;

public class Main3 {
	private static char[] arr= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			int fsx = scanner.nextInt();
			int tsx = scanner.nextInt();
			String result = getResult(num, fsx, tsx);
			if (result.length() <= 7) {
				System.out.printf("%7s", result);
			} else {
				System.out.println("  ERROR");

			}
		}
	}

	private static String getResult(int num, int fsx, int tsx) {
		int ordNum = 0;
		int i = 0;
		while (num != 0) {
			ordNum += (num % 10) * Math.pow(fsx, i);
			num/=10;
			i++;
		}
		
		StringBuilder result = new StringBuilder();
		while(ordNum!=0) {
			result.append(arr[ordNum%tsx]);
			ordNum/=tsx;
		}
		return result.reverse().toString();
	}
}

