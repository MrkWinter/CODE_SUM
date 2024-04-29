package com.dataStract.unit2._04digui;

import java.util.Arrays;

public class NQUeeue {
	public static void main(String[] args) {
		NQueue(3);
	}

	public static void NQueue(int n) {
		int[] board = new int[n];
		Arrays.fill(board, -1);
		NQueue(n, 0, board);
	}

	public static void NQueue(int n, int r, int[] board) {
		if (r >= n) {
			System.out.println(Arrays.toString(board) + "\n");
			return;
		}
		for (int c = 0; c < n; c++) {
			if (isTrue(r, c, board)) {
				board[r] = c;
				NQueue(n, r + 1, board);
			}
		}
		board[r] = -1;

	}

	private static boolean isTrue(int r, int c, int[] board) {
		for (int j = 0; j < r; j++) {
			if (board[j] == c)
				return false;
			if(Math.abs(c - board[j]) == r-j)
				return false;
		}
		return true;
	}

}
