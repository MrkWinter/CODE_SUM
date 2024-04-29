package com.learn4;

import java.io.IOException;
import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			char[][] arr = new char[row][col];
			scanner.nextLine();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextLine().toCharArray();
			}
			int x = scanner.nextInt() - 1; // xy是数组中的绝对位置
			int y = scanner.nextInt() - 1;
			Point point = new Point(x, y, arr);
			char m = ' ';
			boolean flag = true;
			while (flag) {
				char[] temp = scanner.nextLine().toCharArray();
				for (int i = 0; i < temp.length; i++) {
					m = temp[i];
					if (m == 'Q') {
						flag = false;
						break;
					}
					if (m == ' ')
						continue;
					if (m == 'F')
						point.goFront();
					else
						point.turnAround(m);
				}
			}
			System.out.println((point.x + 1) + " " + (point.y + 1) + " " + point.where);
		}
	}

	static class Point {
		int x;
		int y;
		char[][] arr;
		char where = 'N';

		public Point(int x, int y, char[][] arr) {
			this.x = x;
			this.y = y;
			this.arr = arr;
		}

		public void turnAround(char m) {
			if (where == 'E') {
				if (m == 'L') {
					where = 'N';
				} else if (m == 'R') {
					where = 'S';
				}

			} else if (where == 'S') {
				if (m == 'L') {
					where = 'E';
				} else if (m == 'R') {
					where = 'W';
				}

			} else if (where == 'W') {
				if (m == 'L') {
					where = 'S';
				} else if (m == 'R') {
					where = 'N';
				}

			} else if (where == 'N') {
				if (m == 'L') {
					where = 'W';
				} else if (m == 'R') {
					where = 'E';
				}

			}
		}

		public void goFront() {
			if (where == 'E') {
				if (arr[x][y + 1] != '*')
					y += 1;
			} else if (where == 'S') {
				if (arr[x + 1][y] != '*')
					x += 1;
			} else if (where == 'W') {
				if (arr[x][y - 1] != '*')
					y -= 1;
			} else if (where == 'N') {
				if (arr[x - 1][y] != '*')
					x -= 1;
			}
		}
	}
}
//7 8
//********
//* * * **
//* *    *
//* * ** *
//* * *  *
//*   * **
//********
//2 4
//RRFLFF FFR
//FF
//RFFQ