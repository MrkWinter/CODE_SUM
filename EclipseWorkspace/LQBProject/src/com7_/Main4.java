package com7_;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[][] board = new boolean[10][9];
		while (true) {
			int fx = scanner.nextInt() - 1;
			int fy = scanner.nextInt() - 1;
			int tx = scanner.nextInt() - 1;
			int ty = scanner.nextInt() - 1;
			if (fx == -1 && fy == -1 && tx == -1 && ty == -1)
				break;
			int num = bfs(fx, fy, tx, ty, board);
			System.out.println(num);
			for (int i = 0; i < board.length; i++) {
				Arrays.fill(board[i], false);
			}
			

		}
	}

	private static int bfs(int fx, int fy, int tx, int ty, boolean[][] board) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { fx, fy });
		int count = 1;
		int whell = 1;
		while (queue.size() != 0) {
			int[] cur = queue.poll();
			count--;
			addQueue(cur[0] - 2, cur[1] - 1, queue, board);
			addQueue(cur[0] - 2, cur[1] + 1, queue, board);
			addQueue(cur[0] - 1, cur[1] + 2, queue, board);
			addQueue(cur[0] + 1, cur[1] + 2, queue, board);
			addQueue(cur[0] + 2, cur[1] + 1, queue, board);
			addQueue(cur[0] + 2, cur[1] - 1, queue, board);
			addQueue(cur[0] + 1, cur[1] - 2, queue, board);
			addQueue(cur[0] - 1, cur[1] - 2, queue, board);
			if (board[tx][ty])
				return whell;
			if (count == 0) {
				count = queue.size();
				whell++;
			}
		}
		return -1;
	}

	private static void addQueue(int i, int j, LinkedList<int[]> queue, boolean[][] board) {

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return;
		if (board[i][j])
			return;
		queue.add(new int[] { i, j });
		board[i][j] = true;

	}
}
