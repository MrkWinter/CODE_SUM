package com.learn4;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int pathLong = scanner.nextInt();
			int up = scanner.nextInt();
			int down = scanner.nextInt();
			if (pathLong == 0 && up == 0 && down == 0)
				break;
			int time = 0;
			boolean needSleep = false;
			while (true) {
				if (!needSleep) {
					time++;
					pathLong -= (up-down);
					needSleep = true;
				}
				if (pathLong <= 0)
					break;
				if (needSleep) {
					time++;
					pathLong += down;
					needSleep = false;
				}

			}
			System.out.println(time);
		}
	}
}
//10 2 1
//20 3 1
//0 0 0