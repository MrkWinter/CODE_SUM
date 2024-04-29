package com.learn3;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int tub = scanner.nextInt();
			int minArea = Integer.MAX_VALUE;
			for (int a = 1; Math.pow(a,3) <=tub; a++) {
				for (int b = a; a* Math.pow(b, 2) <= tub; b++) {
					if(tub%(a*b) == 0) {
						int c = tub /(a*b);
						int curArea = (a*b + a*c + b*c)*2;
						if(curArea<minArea) {
							minArea = curArea;
						}
					}
				}
			}
			System.out.println(minArea);
		}
	}
}
