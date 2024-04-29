package com6_;

import java.util.ArrayList;
import java.util.Scanner;

public class Main5 {
	private static ArrayList<Integer> prime = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 2; i < 50; i++) {
			boolean flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				prime.add(i);
		}
		int count = 1;
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			System.out.println("Case " + count++ + ":");
			if (n % 2 == 0) {
				showResult(1, n, list);
			}
			System.out.println();
		}
	}

	private static void showResult(int cur, int size, ArrayList<Integer> list) {
		list.add(cur);
		if (list.size() == size) {
			for (Integer c : list) {
				System.out.print(c + " ");
			}
			System.out.println();
			return;
		}
		for (int j = 2; j <= size; j++) {
			if (!list.contains(j) && isKingPrime(j, size, list)) {
				showResult(j, size, list);
				list.remove(new Integer(j));
			}
		}
	}

	private static boolean isKingPrime(int cur, int n, ArrayList<Integer> list) {
		int size = list.size();
		if (list.size() == 0)
			return true;
		Integer preNum = list.get(size - 1);
		Integer nextNum = list.get(0);
		if (size != n - 1) {
			if (prime.contains(preNum + cur)) {
				return true;
			}
		} else if (size == n - 1) {
			if (prime.contains(preNum + cur) && prime.contains(nextNum + cur)) {
				return true;
			}
		}
		return false;
	}
}
