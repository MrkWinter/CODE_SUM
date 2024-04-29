package com.learn5;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		char[][] arr = new char[3][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scanner.next().toCharArray();
			}
			// ÅÐ¶Ï
			// 1. Æå×Ó¸öÊý
			int x = 0;
			int o = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[0].length; k++) {
					if (arr[j][k] == 'X')
						x++;
					if (arr[j][k] == 'O')
						o++;
				}
			}
			if (!(x == o || x == o + 1)) {
				System.out.println("no");
				continue;
			}
			boolean twoWin = false;
			char win = ' ';
			for (int j = 0; j < arr.length; j++) {
				if (arr[0][j] == arr[1][j] && arr[1][j] == arr[2][j] && arr[0][j] != '.') {
					if (win == ' ') 
						win = arr[0][j];
					else if (win != arr[0][j])
						twoWin =true;
				}
				if (arr[j][0] == arr[j][1] && arr[j][1] == arr[j][2] && arr[j][0] != '.') {
					if (win == ' ') 
						win = arr[j][0];
					else if (win != arr[j][0])
						twoWin =true;
				}
				if (j == 0 && arr[j][j] == arr[j + 1][j + 1] && arr[j + 1][j + 1] == arr[j + 2][j + 2]
						&& arr[j][j] != '.') {
					if (win == ' ') 
						win = arr[j][j];
					else if (win != arr[j][j])
						twoWin =true;
				}
				if (j == 0 && arr[j][j + 2] == arr[j + 1][j + 1] && arr[j + 1][j + 1] == arr[j + 2][j]
						&& arr[j][j + 2] != '.') {	
					if (win == ' ') 
						win = arr[j][j + 2];
					else if (win != arr[j][j + 2])
						twoWin =true;
				}
			}
			if (twoWin) {
				System.out.println("no");
				continue;
			}
			if (win == 'X' && x != o + 1) {
				System.out.println("no");
				continue;
			}
			if (win == 'O' && x != o) {
				System.out.println("no");
				continue;
			}
			System.out.println("yes");
		}
	}
}
//2
//X.O
//OO.
//XXX
//
//O.X
//XX.
//OOO