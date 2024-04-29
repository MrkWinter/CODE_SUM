package com7_;

import java.util.Scanner;

public class Main3 {
	private static boolean find = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[6];
		int count = 1;
		while (true) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();
				sum += arr[i] * (i + 1);
			}
			if (sum == 0)
				break;
			System.out.println("Collection #" + count++ + ":");
			if (sum % 2 != 0) {
				System.out.println("Can't be divided.\n");
				continue;
			}

			int tarNum = sum / 2;
			find = false;
			dfs(0, tarNum, arr);
			if (find) {
				System.out.println("Can be divided.\n");
			} else {
				System.out.println("Can't be divided.\n");
			}
		}
	}

	private static void dfs(int curSum, int target, int[] arr) {
		if (curSum == target) {
			find = true;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(find)
				return;
			if (arr[i] == 0)
				continue;
			if (curSum + (i + 1) > target)
				return;
			arr[i]--;
			dfs(curSum + (i + 1), target, arr);
			arr[i]++;
		}
	}
}
//Collection #1:
//Can't be divided.
//
//Collection #2:
//Can be divided.