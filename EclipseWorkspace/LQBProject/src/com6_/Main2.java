package com6_;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int x = scanner.nextInt() - 1;
			int y = scanner.nextInt() - 1;
			scanner.nextLine();
			if (m == 0 && n == 0 && x == 0 && y == 0)
				break;
			char[][] arr = new char[m][n];
			for (int i = 0; i < m; i++) {
				arr[i] = scanner.nextLine().toCharArray();
			}
			int result = 0;
			if (arr[x][y] == '.') {
				System.out.println(result);
				continue;
			}

			result = dfs(x, y, arr);
			System.out.println(result);
		}
	}

	private static int dfs(int x, int y, char[][] arr) {
		int count = 0;
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] == '.')
			return 1;
		if (arr[x][y] == 'x')
			return 0;
		arr[x][y] = 'x';
		count += dfs(x - 1, y, arr);
		count += dfs(x, y + 1, arr);
		count += dfs(x + 1, y, arr);
		count += dfs(x, y - 1, arr);

		if (x - 1 >= 0 && y - 1 >= 0 && arr[x-1][y-1] == 'X') {
			count += dfs(x - 1, y - 1, arr);
		}
		if (x - 1 >= 0 && y + 1 < arr[0].length && arr[x-1][y+1] == 'X') {
			count += dfs(x - 1, y + 1, arr);
		}
		if (x + 1 < arr.length && y - 1 >= 0 && arr[x+1][y-1] == 'X') {
			count += dfs(x + 1, y - 1, arr);
		}
		if (x + 1 < arr.length && y + 1 < arr[0].length && arr[x+1][y+1] == 'X') {
			count += dfs(x + 1, y + 1, arr);
		}
		return count;
	}
}
