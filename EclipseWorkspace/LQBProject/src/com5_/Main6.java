package com5_;

import java.util.ArrayList;
import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			ArrayList<int[]> list = new ArrayList<int[]>();

			for (int i = 0; i < n; i++) {
				list.add(new int[] { scanner.nextInt(), 0 });
			}
			for (int i = 0; i < n; i++) {
				list.get(i)[1] = scanner.nextInt();
			}
			list.sort((int[] a1, int[] a2) -> a1[1] - a2[1]);
			int beg = scanner.nextInt();
			int end = scanner.nextInt();

			int count = 0;
			int curBegin = 0;
			for (int i = 0; i < n; i++) {
				int[] tempArr = list.get(i);
				if (tempArr[1] <= beg) {
					if (tempArr[0] >= curBegin) {
						curBegin = tempArr[1];
						count++;
					}
				} else if (tempArr[0] >= end) {
					if (tempArr[0] >= curBegin) {
						curBegin = tempArr[1];
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
