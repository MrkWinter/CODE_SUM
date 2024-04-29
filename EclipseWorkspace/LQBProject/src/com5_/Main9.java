package com5_;

import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int t = scanner.nextInt();
			scanner.nextLine();
			char[][] arr = new char[n][m];
			int x = 0;
			int y = 0;
			for (int i = 0; i < n; i++) {
				char[] temp = scanner.nextLine().toCharArray();
				for (int j = 0; j < temp.length; j++) {
					arr[i][j] = temp[j];
					if (temp[j] == 'S') {
						x = i;
						y = j;
					}
				}
			}
			boolean result = findPath(x, y, 0, t, arr);
			if (result)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	private static boolean findPath(int x, int y, int curTime, int t, char[][] arr) {
		boolean result = false;
		if (curTime > t)
			return result;
		if (curTime == t && arr[x][y] == 'D')
			return true;
		arr[x][y] = '*';
		if (x - 1 >= 0) {
			if (arr[x - 1][y] == '.' || arr[x - 1][y] == 'D') {
				result = findPath(x - 1, y, curTime + 1, t, arr);
				arr[x - 1][y] = '.';
				if(result)
					return true;
			}
		}
		if (y + 1 < arr[0].length) {
			if (arr[x][y + 1] == '.' || arr[x][y + 1] == 'D') {
				result = findPath(x, y + 1, curTime + 1, t, arr);
				arr[x][y + 1] = '.';
				if(result)
					return true;
			}
		}
		if (x + 1 < arr.length) {
			if (arr[x + 1][y] == '.' || arr[x + 1][y] == 'D') {
				result = findPath(x + 1, y, curTime + 1, t, arr);
				arr[x + 1][y] = '.';
				if(result)
					return true;
			}
		}
		if (y - 1 >= 0) {
			if (arr[x][y - 1] == '.' || arr[x][y - 1] == 'D') {
				result = findPath(x, y - 1, curTime + 1, t, arr);
				arr[x][y - 1] = '.';
				if(result)
					return true;
			}
		}
		return result;
	}
}
