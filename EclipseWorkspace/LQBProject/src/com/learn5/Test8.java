package com.learn5;

import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			char[][] boomArr = new char[n][n];
			for (int i = 0; i < boomArr.length; i++) {
				boomArr[i] = scanner.next().toCharArray();
			}
			boolean flag = false;// 表示点开了地雷
			char[][] result = new char[n][n];
			for (int i = 0; i < boomArr.length; i++) {
				char[] row = scanner.next().toCharArray();
				for (int j = 0; j < row.length; j++) {
					if (row[j] == 'x') {
						int num = getNum(boomArr, i, j);
						if (num == -1) {
							flag = true;
						} else {
							result[i][j] = (num + "").charAt(0);
						}
					} else {
						result[i][j] = '.';
					}
				}
			}
			// 如果点开地雷 将*置入
			if (flag) {
				for (int i = 0; i < boomArr.length; i++) {
					for (int j = 0; j < boomArr[0].length; j++) {
						if (boomArr[i][j] == '*')
							result[i][j] = '*';
					}
				}
			}
			// 输出
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					System.out.print(result[i][j]);
				}
				System.out.println();
			}

		}
	}

	public static int getNum(char[][] boomArr, int x, int y) { // -1表示点开地雷
		int wen = boomArr.length - 1;
		int len = boomArr[0].length - 1;
		int count = 0;
		if (boomArr[x][y] == '*')
			return -1;
		if (x - 1 >= 0 && y - 1 >= 0 && boomArr[x - 1][y - 1] == '*')
			count++;
		if (x - 1 >= 0 && boomArr[x - 1][y] == '*')
			count++;
		if (x - 1 >= 0 && y + 1 <= len && boomArr[x - 1][y + 1] == '*')
			count++;
		if (y - 1 >= 0 && boomArr[x][y - 1] == '*')
			count++;
		if (y + 1 <= len && boomArr[x][y + 1] == '*')
			count++;
		if (x + 1 <= wen && y - 1 >= 0 && boomArr[x + 1][y - 1] == '*')
			count++;
		if (x + 1 <= wen && boomArr[x + 1][y] == '*')
			count++;
		if (x + 1 <= wen && y + 1 <= len && boomArr[x + 1][y + 1] == '*')
			count++;
		return count;
	}
}
//8
//...**..*
//......*.
//....*...
//........
//........
//.....*..
//...**.*.
//.....*..

//xxx.....
//xxxx....
//xxxx....
//xxxxx...
//xxxxx...
//xxxxx...
//xxx.....
//xxxxx...

//001.....
//0013....
//0001....
//00011...
//00001...
//00123...
//001.....
//00123...