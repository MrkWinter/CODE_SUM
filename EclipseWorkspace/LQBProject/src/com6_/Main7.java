package com6_;

import java.util.Scanner;

public class Main7 {
	private static int count = 0;
	private static int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int n = scanner.nextInt();
			if(n == 0)
				break;
			count = 0;
			dfs(0,0,n);
			System.out.println(count);
			
		}
	}
	private static void dfs(int cur, int n,int sum) {
		if(cur == sum) {
			count++;
			return;
		}
		for (int i = n; i < squares.length; i++) {
			if(cur+squares[i]>sum)
				break;
			dfs(cur+squares[i],i,sum);
		}
	}
}
