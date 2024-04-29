package com6_;

import java.util.Scanner;

public class Main4 {
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			scanner.nextLine();
			char[][] arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextLine().toCharArray();
			}
			max = Integer.MIN_VALUE;
			dfs(0, 0, 0, arr);
			System.out.println(max);

		}
	}

	private static void dfs(int x, int y, int c, char[][] arr) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] == 'E' || arr[x][y] == 'O'
				|| arr[x][y] == 'X') {
			return;
		}
		if (canBuild(x, y, arr)) {
			arr[x][y] = 'O';
			c += 1;
			max = Math.max(max, c);
			dfs(x, y - 1, c, arr);
			dfs(x, y + 1, c, arr);
			dfs(x - 1, y, c, arr);
			dfs(x + 1, y, c, arr);
			arr[x][y] = 'E';
			dfs(x, y - 1, c-1, arr);
			dfs(x, y + 1, c-1, arr);
			dfs(x - 1, y, c-1, arr);
			dfs(x + 1, y, c-1, arr);
		} else {
			arr[x][y] = 'E';
			dfs(x, y - 1, c, arr);
			dfs(x, y + 1, c, arr);
			dfs(x - 1, y, c, arr);
			dfs(x + 1, y, c, arr);
		}
		arr[x][y] = '.';

	}

	private static boolean canBuild(int x, int y, char[][] arr) {
		if (arr[x][y] == 'X')
			return false;
		int tempx = x;
		while (tempx >= 0) {
			if (arr[tempx][y] == 'X')
				break;
			if (arr[tempx][y] == 'O')
				return false;
			tempx--;
		}
		tempx = x;
		while (tempx < arr.length) {
			if (arr[tempx][y] == 'X')
				break;
			if (arr[tempx][y] == 'O')
				return false;
			tempx++;
		}
		int tempy = y;
		while (tempy >= 0) {
			if (arr[x][tempy] == 'X')
				break;
			if (arr[x][tempy] == 'O')
				return false;
			tempy--;
		}
		tempy = y;
		while (tempy < arr.length) {
			if (arr[x][tempy] == 'X')
				break;
			if (arr[x][tempy] == 'O')
				return false;
			tempy++;
		}
		return true;
	}
}
