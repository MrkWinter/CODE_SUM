package com7_;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.border.Border;

public class Main5 {
	public static boolean[][] row;
	public static boolean[][] col;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			if (m == 0 && n == 0)
				break;
			int tx = scanner.nextInt() - 1;
			int ty = scanner.nextInt() - 1;
			boolean[][] board = new boolean[m][n];
			row = new boolean[m][n];
			col = new boolean[m][n];
			int p = scanner.nextInt();
			int[] postion = new int[p * 2];
			for (int i = 0; i < postion.length; i++) {
				postion[i] = scanner.nextInt() - 1;
			}
			int num = bfs(postion, tx, ty, board);
			System.out.println(num);

			for (int i = 0; i < board.length; i++) {
				Arrays.fill(board[i], false);
				Arrays.fill(row[i], false);
				Arrays.fill(col[i], false);
			}
		}
	}

	private static int bfs(int[] postion, int tx, int ty, boolean[][] board) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(postion);
		if(postion.length == 2)
			board[postion[0]][postion[1]] = true;
		else if(postion[0] == postion[2]){
			row[postion[2]][postion[3]] = true;
		} else {
			col[postion[2]][postion[3]] = true;
		}
		int whell = 1;
		int count = 1;
		while (queue.size() != 0) {
			int[] cur = queue.poll();
			count--;
			addNextQueue(cur, queue, board);
			if (board[tx][ty]) {
				return whell;
			}
			if (count == 0) {
				whell++;
				count = queue.size();
			}
		}
		return -1;
	}

	private static void addNextQueue(int[] cur, LinkedList<int[]> queue, boolean[][] board) {
		if (cur.length == 2) {
			// µã
			if (isInArea(cur[0] - 2, cur[1], row)) {
				queue.add(new int[] { cur[0] - 1, cur[1], cur[0] - 2, cur[1] });
				row[cur[0] - 2][cur[1]] = true;
			}
			if (isInArea(cur[0], cur[1] + 2, col)) {
				queue.add(new int[] { cur[0], cur[1] + 1, cur[0], cur[1] + 2 });
				col[cur[0]][cur[1] + 2] = true;
			}
			if (isInArea(cur[0] + 2, cur[1], row) && isInArea(cur[0] + 1, cur[1], row)) {
				queue.add(new int[] { cur[0] + 2, cur[1], cur[0] + 1, cur[1] });
				row[cur[0] + 1][cur[1]] = true;
			}
			if (isInArea(cur[0], cur[1] - 2, col) && isInArea(cur[0], cur[1] - 1, col)) {
				queue.add(new int[] { cur[0], cur[1] - 2, cur[0], cur[1] - 1 });
				col[cur[0]][cur[1] - 1] = true;
			}
		} else if (cur[0] == cur[2]) {
			// ºá
			if (isInArea(cur[2] - 1, cur[3], row)) {
				queue.add(new int[] { cur[0] - 1, cur[1], cur[2] - 1, cur[3] });
				row[cur[2] - 1][cur[3]] = true;
			}
			if (isInArea(cur[2], cur[3] + 1, board)) {
				queue.add(new int[] { cur[2], cur[3] + 1 });
				board[cur[2]][cur[3] + 1] = true;
			}
			if (isInArea(cur[2] + 1, cur[3], row)) {
				queue.add(new int[] { cur[0] + 1, cur[1], cur[2] + 1, cur[3] });
				row[cur[2] + 1][cur[3]] = true;
			}
			if (isInArea(cur[0], cur[1] - 1, board)) {
				queue.add(new int[] { cur[0], cur[1] - 1 });
				board[cur[0]][cur[1] - 1] = true;
			}
		} else {
			// Êú
			if (isInArea(cur[2] - 1, cur[3], board)) {
				queue.add(new int[] { cur[2] - 1, cur[3] });
				board[cur[2] - 1][cur[3]] = true;
			}
			if (isInArea(cur[2], cur[3] + 1, col)) {
				queue.add(new int[] { cur[0], cur[1] + 1, cur[2], cur[3] + 1 });
				col[cur[2]][cur[3] + 1] = true;
			}
			if (isInArea(cur[0] + 1, cur[1], board)) {
				queue.add(new int[] { cur[0] + 1, cur[1] });
				board[cur[0] + 1][cur[1]] = true;
			}
			if (isInArea(cur[2], cur[3] - 1, col)) {
				queue.add(new int[] { cur[0], cur[1] - 1, cur[2], cur[3] - 1 });
				col[cur[2]][cur[3] - 1] = true;
			}
		}
	}

	private static boolean isInArea(int x, int y, boolean[][] board) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return false;
		if (board[x][y])
			return false;
		return true;
	}
}

//4 4 2 3
//2 1 1 1 2
//4 5 4 5
//1 1 1
//0 0