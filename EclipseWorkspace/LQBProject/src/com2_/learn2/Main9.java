package com2_.learn2;

import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			char[] arr = scanner.next().toCharArray();
			if (arr[0] == '0')
				break;
			int sum = 0;
			while (true) {
				for (int i = 0; i < arr.length; i++) {
					sum += (arr[i] - '0');
				}
				arr = String.valueOf(sum).toCharArray();
				if (arr.length == 1)
					break;
				sum = 0;
			}
			System.out.println(arr[0]);
		}
	}
}
