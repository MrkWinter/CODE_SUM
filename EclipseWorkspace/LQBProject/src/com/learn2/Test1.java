package com.learn2;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int falseTickNum = 0;
			int putTickNum = scanner.nextInt();
			int getTickNum = scanner.nextInt();
			if(putTickNum == 0 && getTickNum == 0)
				break;
			boolean[] tickArr = new boolean[putTickNum + 1];
			boolean[] falseArr = new boolean[putTickNum + 1];
			for (int i = 0; i < getTickNum; i++) {
				int getTick = scanner.nextInt();
				if (tickArr[getTick] && !falseArr[getTick]) {
					falseTickNum++;
          falseArr[getTick] = true;
				} else {
					tickArr[getTick] = true;
				}
			}
			System.out.println(falseTickNum);
		}
	}
}
