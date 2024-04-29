package com.learn4;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			double[][] arr = new double[6][6];
			for (int j = 1; j < arr.length; j++) {
				for (int k = 1; k < arr.length; k++) {
					arr[j][k] = scanner.nextDouble();
				}
			}
			// 汇率表 arr
			while (true) {
				int putId = 1;
				int times = scanner.nextInt(); // 周游次数
				if(times == 0)
					break;
				int[] choice = new int[times];
				for (int j = 0; j < choice.length; j++) {
					choice[j] = scanner.nextInt();
				}
				double money = scanner.nextDouble();
				for (int j = 0; j < times; j++) {
					int county = choice[j];
					money = new BigDecimal(money * arr[putId][county]).setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue();
					putId = county;
				}
				money = new BigDecimal(money * arr[putId][1]).setScale(2, BigDecimal.ROUND_HALF_UP)
						.doubleValue();
				System.out.println(money);
			}
			System.out.println();
		}
	}
}
//1

//1 1.57556 1.10521 0.691426 7.25005
//0.634602 1 0.701196 0.43856 4.59847
//0.904750 1.42647 1 0.625627 6.55957
//1.44616 2.28059 1.59840 1 10.4843
//0.137931 0.217555 0.152449 0.0953772 1
//3 2 4 5 20.00
//6 2 3 4 2 4 3 120.03
//0