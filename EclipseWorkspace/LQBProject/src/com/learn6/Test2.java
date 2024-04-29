package com.learn6;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int day = scanner.nextInt();
			char[][] arr = new char[row][col];
			// 地图
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scanner.next().toCharArray();
			}
			// 战争 与 扩张的变化
			ArrayList<Object[]> change = new ArrayList<Object[]>();
			// 战争
			for (int d = 0; d < day; d++) {

				for (int j = 0; j < arr.length; j++) {
					for (int k = 0; k < arr[0].length; k++) {
						char cur = ' ';
						if ((cur = beAggress(arr[j][k], arr, j, k)) != ' ') {
							change.add(new Object[] { j, k, cur });
						}
					}
				}
				// 扩张
				for (Object[] o : change) {
					arr[(int) o[0]][(int) o[1]] = (char) o[2];
				}
				change.clear();
			}
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[0].length; k++) {
					System.out.print(arr[j][k]);
				}
				System.out.println();
			}
		}
	}

	private static char beAggress(char cur, char[][] arr, int j, int k) {
		int len = arr.length - 1;
		if (cur == 'R') {
			if ((j - 1 >= 0 && arr[j - 1][k] == 'P') || (j + 1 <= len && arr[j + 1][k] == 'P')
					|| (k - 1 >= 0 && arr[j][k - 1] == 'P') || (k + 1 <= len && arr[j][k + 1] == 'P')) {
				return 'P';
			}
		} else if (cur == 'S') {
			if ((j - 1 >= 0 && arr[j - 1][k] == 'R') || (j + 1 <= len && arr[j + 1][k] == 'R')
					|| (k - 1 >= 0 && arr[j][k - 1] == 'R') || (k + 1 <= len && arr[j][k + 1] == 'R')) {
				return 'R';
			}
		} else if (cur == 'P') {
			if ((j - 1 >= 0 && arr[j - 1][k] == 'S') || (j + 1 <= len && arr[j + 1][k] == 'S')
					|| (k - 1 >= 0 && arr[j][k - 1] == 'S') || (k + 1 <= len && arr[j][k + 1] == 'S')) {
				return 'S';
			}
		}
		return ' ';
	}
}
//2
//3 3 1
//RRR
//RSR
//RRR
//3 4 2
//RSPR
//SPRS
//PRSP