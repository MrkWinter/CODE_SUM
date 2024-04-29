package com6_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main8 {
	private static boolean flag = false;
	private static int sum = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			sum = scanner.nextInt();
			int n = scanner.nextInt();
			if (sum == 0 && n == 0) {
				break;
			}
			int[] arr = new int[n];
			boolean[] isGet = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
			System.out.println("Sums of " + sum + ":");
			flag = false;
			ArrayList<Integer> list = new ArrayList<Integer>();
			int cur = 0;
			for (int i = 0; i < n; i++) {
				if (cur == arr[i]) {
					continue;
				}
				cur = arr[i];
				dfs(i, list, arr, isGet);
				list.clear();
			}
			if (!flag) {
				System.out.println("NONE");
			}
		}
	}

	private static void dfs(int cIndex, ArrayList<Integer> curSum, int[] arr, boolean[] isGet) {
		curSum.add(arr[cIndex]);
		int temp = getSum(curSum);
		if (temp > sum)
			return;
		if (temp == sum) {
			flag = true;
			for (int i = 0; i < curSum.size(); i++) {
				System.out.print(curSum.get(i));
				if (i != curSum.size() - 1) {
					System.out.print("+");
				} else {
					System.out.println();
				}
			}
		}
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = cIndex + 1; i < arr.length; i++) {
			if (!isGet[i] && !(hashSet.contains(arr[i]))) {
				hashSet.add(arr[i]);
				dfs(i, curSum, arr, isGet);
				curSum.remove(curSum.size() - 1);
			}
		}
	}

	private static int getSum(ArrayList<Integer> curSum) {
		int sum = 0;
		for (int i = 0; i < curSum.size(); i++) {
			sum += curSum.get(i);
		}
		return sum;
	}
}
