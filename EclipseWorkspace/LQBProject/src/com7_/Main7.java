package com7_;

import java.util.LinkedList;
import java.util.Scanner;

public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int fx = 0;
			int fy = 0;
			int ax = 0;
			int ay = 0;
			scanner.nextLine();
			char[][] arr = new char[row][col];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextLine().toCharArray();
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] == 'a') {
						ax = i;
						ay = j;
					} else if (arr[i][j] == 'r') {
						fx = i;
						fy = j;
					}
				}
			}
			int num = dfs(ax, ay, fx, fy, arr);
			if (num != -1) {
				System.out.println(num);
			} else {
				System.out.println("Poor ANGEL has to stay in the prison all his life.");
			}

		}

	}

	private static int dfs(int ax, int ay, int fx, int fy, char[][] arr) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		arr[fx][fy] = '*';
		queue.add(new int[] { fx, fy });
		int count = 1;
		int whell = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			count--;
			addQueue(cur[0] - 1, cur[1], arr, queue);
			addQueue(cur[0] + 1, cur[1], arr, queue);
			addQueue(cur[0], cur[1] - 1, arr, queue);
			addQueue(cur[0], cur[1] + 1, arr, queue);
			if (arr[ax][ay] == '*')
				return whell;
			if (count == 0) {
				count = queue.size();
				whell++;
			}
		}
		return -1;
	}

	private static void addQueue(int x, int y, char[][] arr, LinkedList<int[]> queue) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
			return;
		}
		if (arr[x][y] == '#' || arr[x][y] == '*') {
			return;
		}

		if (arr[x][y] != 'x') {
			arr[x][y] = '*';
			queue.add(new int[] { x, y });
		} else {
			arr[x][y] = '.';
		}
	}
}
