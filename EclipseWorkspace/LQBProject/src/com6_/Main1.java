package com6_;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			scanner.nextLine();
			if (n == 0 && m == 0) {
				break;
			}
			boolean[][] map = new boolean[n][];
			char[][] arr = new char[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextLine().toCharArray();
				map[i] = new boolean[arr[i].length];
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] == ' ')
						continue;
					int num = dfs(i, j, arr[i][j], arr);
					max = Math.max(max, num);
				}
			}
			System.out.println(max);
		}
	}

	private static int dfs(int x, int y, char c, char[][] arr) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[x].length || arr[x][y] != c) {
			return 0;
		}
		arr[x][y] = ' ';
		int count = 1;
		count += dfs(x, y - 1, c, arr);
		count += dfs(x, y + 1, c, arr);
		count += dfs(x - 1, y, c, arr);
		count += dfs(x + 1, y, c, arr);
		if (x % 2 == 0) {
			// ÆæÊý
			count += dfs(x - 1, y - 1, c, arr);
			count += dfs(x + 1, y - 1, c, arr);
		} else {
			// Å¼Êý
			count += dfs(x - 1, y + 1, c, arr);
			count += dfs(x + 1, y + 1, c, arr);
		}
		return count;
	}
}
