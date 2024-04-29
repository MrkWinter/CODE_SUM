package com.learn1;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // n组数据
		int[] result = new int[n]; // 结果数据
		for (int i = 0; i < result.length; i++) {
			int getNum = scan.nextInt();// 本组数据多少个数字
			int j = 0;
			int o = 0;
			for (int k = 0; k < getNum; k++) {
				if (scan.nextInt() % 2 == 0)
					o++;
				else
					j++;
			}
			if (j % 2 != 0)
				result[i] = 0;
			else
				result[i] = ((int) (Math.pow(2, o) * Math.pow(2, (j == 0 ? 0 : j - 1)))) % 1000000007;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
