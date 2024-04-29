package com.learn1;

import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			if(x%2 == 0) {
				if(x == y) {
					System.out.println(2*x);
				} else if(y == x-2) {
					System.out.println(2*x -2);
				} else {
					System.out.println("No Number");
				}
				
			} else {
				if( x ==  y) {
					System.out.println(x*2-1);
				} else if(y == x-2) {
					System.out.println(x*2-3);
				} else {
					System.out.println("No Number");
				}
			}
		}
	}
}
