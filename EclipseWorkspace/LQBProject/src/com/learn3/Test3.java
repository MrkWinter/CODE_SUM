package com.learn3;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int minX = scanner.nextInt();
			int minY = scanner.nextInt();
			if (minX == 0 && minY == 0)
				break;
			int maxX = minX;
			int maxY = minY;
			int curX = 0;
			int curY = 0;
			while (true) {
				curX = scanner.nextInt();
				curY = scanner.nextInt();
				if(curX == 0 && curY == 0)
					break;
				maxX = Math.max(maxX, curX);
				maxY = Math.max(maxY, curY);
				minX = Math.min(minX, curX);
				minY = Math.min(minY, curY);
			}
			System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
		}
	}
}

//12 56
//23 56
//13 10
//0 0
//12 34
//0 0
//0 0

//12 10 23 56
//12 34 12 34