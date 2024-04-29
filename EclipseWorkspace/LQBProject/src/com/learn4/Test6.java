package com.learn4;

import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			boolean[] prison = new boolean[num + 1];
			int count = 1;
			for (int l = 1; l < prison.length; l++) {
				for (int j = 1; j < prison.length; j++) {
					if (j % count == 0) {
						prison[j] = prison[j] ? false : true;
					}
				}
				count += 1;
			}
			int goNum = 0;
			for (int j = 1; j < prison.length; j++) {
				if (prison[j])
					goNum += 1;
			}
			System.out.println(goNum);
		}
	}
}
//2
//5
//100