package com.learn8;

import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 字符串数组表示数字
		String[][] numStr = new String[5][10];
		numStr[0][0] = "***";
		numStr[0][1] = "*";
		numStr[0][2] = "***";
		numStr[0][3] = "***";
		numStr[0][4] = "* *";
		numStr[0][5] = "***";
		numStr[0][6] = "***";
		numStr[0][7] = "***";
		numStr[0][8] = "***";
		numStr[0][9] = "***";
		
		numStr[1][0] = "* *";
		numStr[1][1] = "*";
		numStr[1][2] = "  *";
		numStr[1][3] = "  *";
		numStr[1][4] = "* *";
		numStr[1][5] = "*  ";
		numStr[1][6] = "*  ";
		numStr[1][7] = "  *";
		numStr[1][8] = "* *";
		numStr[1][9] = "* *";
		
		numStr[2][0] = "* *";
		numStr[2][1] = "*";
		numStr[2][2] = "***";
		numStr[2][3] = "***";
		numStr[2][4] = "***";
		numStr[2][5] = "***";
		numStr[2][6] = "***";
		numStr[2][7] = "  *";
		numStr[2][8] = "***";
		numStr[2][9] = "***";
		
		numStr[3][0] = "* *";
		numStr[3][1] = "*";
		numStr[3][2] = "*  ";
		numStr[3][3] = "  *";
		numStr[3][4] = "  *";
		numStr[3][5] = "  *";
		numStr[3][6] = "* *";
		numStr[3][7] = "  *";
		numStr[3][8] = "* *";
		numStr[3][9] = "  *";
		
		numStr[4][0] = "***";
		numStr[4][1] = "*";
		numStr[4][2] = "***";
		numStr[4][3] = "***";
		numStr[4][4] = "  *";
		numStr[4][5] = "***";
		numStr[4][6] = "***";
		numStr[4][7] = "  *";
		numStr[4][8] = "***";
		numStr[4][9] = "***";
		
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			char[] numArr = new StringBuilder(n + "").toString().toCharArray();
			for (int i = 0; i < numStr.length; i++) {
				for (int j = 0; j < numArr.length; j++) {
					System.out.print(numStr[i][new Integer(numArr[j] + "")] + " ");
				}
				System.out.println();
			}
		}
	}
}
