package com7_;

import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int n = scanner.nextInt();
			if(n  == 0)
				break;
			int[][] arr = new int[n][n];
			int tempj = arr.length -1;
			int tempi = 0;
			while(tempj>=0 && tempi<=arr.length-1) {
				int i = tempi;
				int j = tempj;
				while(i<=arr.length-1 && j<=arr.length-1) {
					arr[i][j] = scanner.nextInt();
					i++;
					j++;
				}
				tempj--;
			}
			tempi = 1;
			tempj =0;
			while(tempi<arr.length &&tempj<arr.length) {
				int i = tempi;
				int j = tempj;
				while(i<arr.length && j<arr.length) {
					arr[i][j] = scanner.nextInt();
					i++;
					j++;
				}
				tempi++;
			}
		}
	}
}
