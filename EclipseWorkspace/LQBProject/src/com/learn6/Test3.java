package com.learn6;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int[][] board = new int[51][51];
			for (int i = 11; i <= 30; i++) {
				board[25][i] = 4; // 1 N 2S 3W 4E
			}
			int tailX = 25;
			int tailY = 11;
			int headX = 25;
			int headY = 30;
			char[] path = scanner.next().toCharArray();
			boolean success = true;
			for (int i = 0; i < path.length; i++) {
				// 尾部处理
				if (board[tailX][tailY] == 1) {
					board[tailX][tailY] = 0;
					tailX -= 1;
				} else if (board[tailX][tailY] == 2) {
					board[tailX][tailY] = 0;
					tailX += 1;
				} else if (board[tailX][tailY] == 3) {
					board[tailX][tailY] = 0;
					tailY -= 1;
				} else if (board[tailX][tailY] == 4) {
					board[tailX][tailY] = 0;
					tailY += 1;
				}

				// 头部处理
				if (path[i] == 'N') {
					board[headX][headY] = 1;
					headX -= 1;
					if (headX <= 0) {
						System.out.println("The worm ran off the board on move " + (i + 1) + ".");
						success = false;
						break;
					} else if (board[headX][headY] != 0) {
						System.out.println("The worm ran into itself on move " + (i + 1) + ".");
						success = false;
						break;
					} else {
						board[headX][headY] = -1;
					}
				} else if (path[i] == 'S') {
					board[headX][headY] = 2;
					headX += 1;
					if (headX >= 51) {
						System.out.println("The worm ran off the board on move " + (i + 1) + ".");
						success = false;
						break;
					} else if (board[headX][headY] != 0) {
						System.out.println("The worm ran into itself on move " + (i + 1) + ".");
						success = false;
						break;
					} else {
						board[headX][headY] = -1;
					}
				} else if (path[i] == 'W') {
					board[headX][headY] = 3;
					headY -= 1;
					if (headY <= 0) {
						System.out.println("The worm ran off the board on move " + (i + 1) + ".");
						success = false;
						break;
					} else if (board[headX][headY] != 0) {
						System.out.println("The worm ran into itself on move " + (i + 1) + ".");
						success = false;
						break;
					} else {
						board[headX][headY] = -1;
					}
				} else if (path[i] == 'E') {
					board[headX][headY] = 4;
					headY += 1;
					if (headY >= 51) {
						System.out.println("The worm ran off the board on move " + (i + 1) + ".");
						success = false;
						break;
					} else if (board[headX][headY] != 0) {
						System.out.println("The worm ran into itself on move " + (i + 1) + ".");
						success = false;
						break;
					} else {
						board[headX][headY] = -1;
					}
				}
			}
			if (success)
				System.out.println("The worm successfully made all " + path.length + " moves.");
		}
	}
}
//18
//NWWWWWWWWWWSESSSWS
//20
//SSSWWNENNNNNWWWWSSSS
//30
//EEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
//0

//The worm successfully made all 18 moves.
//The worm ran into itself on move 9.
//The worm ran off the board on move 21.