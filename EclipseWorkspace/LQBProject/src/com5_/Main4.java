package com5_;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			ArrayList<int[]> list = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) {
				list.add(new int[] { i + 1, 0, 0 });
			}
			for (int i = 0; i < n; i++) {
				list.get(i)[1] = scanner.nextInt();
			}
			for (int i = 0; i < n; i++) {
				list.get(i)[2] = scanner.nextInt();
			}
			list.sort((int[] a1, int[] a2) -> a1[2] - a2[2]);
			ArrayList<Integer> result = new ArrayList<Integer>();
			int curTime = 0;
			for (int i = 0; i < n; i++) {
				int[] temp = list.get(i);
				if (temp[1] >= curTime) {
					result.add(temp[0]);
					curTime = temp[2];
				}
			}
			result.sort((a1, a2) -> a1 - a2);
			System.out.println(result.size());
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i));
				if (i != result.size() - 1) {
					System.out.print(" ");
				} else {
					System.out.println();
				}
			}
		}
	}
}
