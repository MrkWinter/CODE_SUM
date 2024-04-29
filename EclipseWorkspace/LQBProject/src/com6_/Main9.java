package com6_;

import java.util.Scanner;

public class Main9 {
	private static boolean flag = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			int[] arr = new int[num];
			boolean[] isUse = new boolean[num];
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scanner.nextInt();
				sum += arr[j];
			}
			flag = false;
			for (int j = 1; j <= sum / 4; j++) {
				dfs(0, j, 0, arr, isUse);
				if (flag)
					break;
			}
			if (flag)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

	private static void dfs(int curSum, int target, int tarNum, int[] arr, boolean[] isUse) {
		if (curSum == target) {
			if (++tarNum == 4) {
				flag = true;
				return;
			}
			curSum = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (flag)
				return;
			if (isUse[i])
				continue;
			if (curSum + arr[i] > target)
				return;
			isUse[i] = true;
			dfs(curSum + arr[i], target, tarNum, arr, isUse);
			isUse[i] = false;
		}
	}
}
