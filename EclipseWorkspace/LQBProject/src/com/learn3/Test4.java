package com.learn3;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			int[] heavy = new int[num + 1];
			int[] light = new int[num + 1];
			boolean[] isTrue = new boolean[num + 1];
			int wightNum = scanner.nextInt();
			int notBallance = 0;
			for (int j = 0; j < wightNum; j++) {
				int putNum = scanner.nextInt();
				int[] temp = new int[putNum * 2];
				for (int k = 0; k < temp.length; k++) {
					temp[k] = scanner.nextInt();
				}
				String res = scanner.next();
				if (res.equals(">")) {
					notBallance++;
					for (int k = 0; k < temp.length; k++) {
						if (k < putNum) {
							heavy[temp[k]] += 1;
						} else {
							light[temp[k]] += 1;
						}
					}
				} else if (res.equals("<")) {
					notBallance++;
					for (int k = 0; k < temp.length; k++) {
						if (k < putNum) {
							light[temp[k]] += 1;
						} else {
							heavy[temp[k]] += 1;
						}
					}
				} else {
					for (int k = 0; k < temp.length; k++) {
						isTrue[temp[k]] = true;
					}
				}
			}
			// 一次称重完
			int falseCoin = 0;
			int falseCoinNum = 0;
			for (int j = 1; j <= num; j++) {
				if (isTrue[j])
					continue;
				if (heavy[j] == notBallance) {
					falseCoin = j;
					falseCoinNum += 1;
				} else if (light[j] == notBallance) {
					falseCoin = j;
					falseCoinNum += 1;
				}
			}
			if (falseCoinNum == 1)
				System.out.println(falseCoin);
			else
				System.out.println(0);
		}
	}
}

//1
//
//5 3
//2 1 2 3 4
//<
//1 1 4
//=
//1 2 5
//=
