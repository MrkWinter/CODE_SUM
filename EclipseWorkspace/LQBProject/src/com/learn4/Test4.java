package com.learn4;

import java.util.Scanner;

public class Test4 {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while(true) {
//			int len = scanner.nextInt();
//			int testNum = scanner.nextInt();
//			if(len == 0 && testNum == 0)
//				break;
//			int[] arr = new int[len];
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = scanner.nextInt();
//			}
//			for (int i = 0; i < testNum; i++) {
//				int t = scanner.nextInt();
//				int bal =Integer.MAX_VALUE;
//				int balSum = 0;
//				int left = 0;
//				int right = 0;
//				for (int j = 0; j < arr.length; j++) {
//					int sum = 0;
//					boolean flag = false;
//					for (int k = j; k < arr.length; k++) {
//						sum+=arr[k];
//						int abs = Math.abs(Math.abs(sum) - t);
//						if(abs<bal) {
//							bal = abs;
//							balSum = sum;
//							left = j;
//							right = k;
//							if(bal == 0) {
//								flag = true;
//								break;
//							}
//						}
//					}
//					if(flag)
//						break;
//				}
//				System.out.println(Math.abs(balSum) + " " + (left+1) + " " + (right+1));
//			}
//		}
//	}

//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while(true) {
//			int len = scanner.nextInt();
//			int testNum = scanner.nextInt();
//			if(len == 0 && testNum == 0)
//				break;
//			int[] arr = new int[len];
//			int[] dp = new int[len];
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = scanner.nextInt();
//			}
//			for (int i = 0; i < testNum; i++) {
//				int t = scanner.nextInt();
//				int left=0;
//				int right = 0;
//				int balSum = arr[0];
//				int bal = Math.abs(Math.abs(arr[0]) - t);
//				dp[0] = arr[0];
//				for (int j = 1; j < dp.length; j++) {
//					int curSum = dp[j] +arr[j+1];
//					int bal1 = Math.abs(Math.abs(curSum) -t);
//					int bal2 = Math.abs(Math.abs(arr[j] -t));
//					if(bal1<bal2) {
//						dp[j] = curSum;
//					}else {
//						dp[j] = arr[j];
//					}
//				}
//			}
//		}
//	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int len = scanner.nextInt();
			int testNum = scanner.nextInt();
			if (len == 0 && testNum == 0)
				break;
			int[] arr = new int[len];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();
			}
			int[][] dp = new int[len][len];
			for (int j = 0; j < dp.length; j++) {
				dp[j][j] = arr[j];
			}
			for (int j = 0; j < dp.length; j++) {
				for (int k = j+1; k < dp.length; k++) {
					dp[j][k] = dp[j][k-1] + arr[k];
				}
			}
			for (int i = 0; i < testNum; i++) {
				int t = scanner.nextInt();
				int left = 0;
				int right = 0;
				int sum = 0;
				int bal = Integer.MAX_VALUE;
				for (int j = 0; j < dp.length; j++) {
					boolean flag = false;
					for (int k = j; k < dp.length; k++) {
						int tempBal = Math.abs(Math.abs(dp[j][k]) - t);
						if(tempBal<bal) {
							bal = tempBal;
							sum = dp[j][k];
							left = j+1;
							right = k+1;
							if(bal == 0) {
								flag = true;
								break;
							}
						}
					}
					if(flag)
						break;
				}				
				System.out.println(Math.abs(sum) + " " + (left) + " " + (right));
			}
		}
	}
}

//5 1
//-10 -5 0 5 10
//3
//10 2
//-9 8 -7 6 -5 4 -3 2 -1 0
//5 11
//0 0

//5 4 4
//5 2 8
//9 1 1