package com.learn3;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[5][6];
		int[][] op = new int[5][6];
		int[][] tempArr = new int[5][6];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					tempArr[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < 64; i++) {
				for (int j = 0; j < 6; j++) {
					op[0][j] = ((i & (1 << j)) > 0 ? 1 : 0);
				}
				pause(0, op[0], arr);
				for (int j = 1; j < 5; j++) {
					for (int j2 = 0; j2 < arr[0].length; j2++) {
						if (arr[j - 1][j2] == 1) {
							op[j][j2] = 1;
						} else {
							op[j][j2] = 0;
						}
					}
					pause(j, op[j], arr);
				}
				boolean isTrue = true;
				for (int j = 0; j < arr[0].length; j++) {
					if (arr[4][j] == 1) {
						isTrue = false;
						break;
					}
				}
				if (isTrue) {
					printArr(op, k + 1);
					break;
				} else {
					for (int l = 0; l < arr.length; l++) {
						for (int j = 0; j < arr[0].length; j++) {
							arr[l][j] = tempArr[l][j];
						}
					}
				}
			}
		}

	}

	private static void printArr(int[][] op, int k) {
		System.out.println("PUZZLE #" + k);
		for (int i = 0; i < op.length; i++) {
			for (int j = 0; j < op[0].length; j++) {
				System.out.print(op[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void pause(int i, int[] js, int[][] arr) {
		for (int j = 0; j < js.length; j++) {
			if (js[j] == 1) {
				arr[i][j] ^= 1;
				if (i - 1 >= 0)
					arr[i - 1][j] ^= 1;
				if (i + 1 <= 4)
					arr[i + 1][j] ^= 1;
				if (j - 1 >= 0)
					arr[i][j - 1] ^= 1;
				if (j + 1 <= 5)
					arr[i][j + 1] ^= 1;
			}
		}
	}

//	PUZZLE #1
//	1 0 1 0 0 1
//	1 1 0 1 0 1
//	0 0 1 0 1 1
//	1 0 0 1 0 0
//	0 1 0 0 0 0
}
