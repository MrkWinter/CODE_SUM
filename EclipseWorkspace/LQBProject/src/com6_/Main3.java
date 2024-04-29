package com6_;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int H = scanner.nextInt();
			int W = scanner.nextInt();
			int h = scanner.nextInt() - 1;
			int w = scanner.nextInt() - 1;
			char[][] arr = new char[H][];
			scanner.nextLine();
			for (int i = 0; i < H; i++) {
				arr[i] = scanner.nextLine().toCharArray();
			}
			int result = 0;
			result += dfs(h, w, arr[h][w], arr);
			if (result < 3)
				result = 0;
			if (result > 0) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						if (arr[i][j] != 'E' && isfloat(i, j, arr)) {
							result += dfs(i, j, arr[i][j], arr);
						}
					}
				}
			}
			System.out.println(result);

		}
	}

	private static int dfsClear(int i, int j, char[][] arr) {
		// TODO Auto-generated method stub
		System.out.println("a");
		return 0;
	}

	private static boolean isfloat(int h, int w, char[][] arr) {
		if (h < 0 || h >= arr.length || w < 0 || w >= arr[h].length || arr[h][w] == 'E' || arr[h][w] == '.')
			return true;
		arr[h][w] = '.';
		boolean flag = true;
		if (h == 0) {
			flag =  false;
		}

		if (!isfloat(h - 1, w, arr)) {
			flag =  false;
		}

		if (!isfloat(h, w + 1, arr)) {
			flag =  false;
		}

		if (!isfloat(h + 1, w, arr)) {
			flag =  false;
		}
		if (!isfloat(h, w - 1, arr)) {
			flag =  false;
		}
		if (h % 2 == 0) {
			// 奇数
			if (!isfloat(h - 1, w - 1, arr)) {
				flag =  false;
			}
			if (!isfloat(h + 1, w - 1, arr)) {
				flag =  false;
			}
		} else {
			// 偶数
			if (!isfloat(h - 1, w + 1, arr)) {
				flag =  false;
			}
			if (!isfloat(h + 1, w + 1, arr)) {
				flag =  false;
			}
		}
		return flag;
	}

	private static int dfs(int h, int w, char c, char[][] arr) {
		if (h < 0 || h >= arr.length || w < 0 || w >= arr[h].length || arr[h][w] != c)
			return 0;
		int count = 1;
		arr[h][w] = 'E';
		count += dfs(h - 1, w, c, arr);
		count += dfs(h, w + 1, c, arr);
		count += dfs(h + 1, w, c, arr);
		count += dfs(h, w - 1, c, arr);
		if (h % 2 == 0) {
			// 奇数
			count += dfs(h - 1, w - 1, c, arr);
			count += dfs(h + 1, w - 1, c, arr);
		} else {
			// 偶数
			count += dfs(h - 1, w + 1, c, arr);
			count += dfs(h + 1, w + 1, c, arr);
		}
		return count;
	}
}
