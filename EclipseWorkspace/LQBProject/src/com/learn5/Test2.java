package com.learn5;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		//Çó10000ÌìµÄÓ²±Ò
		int[] arr = new int[10000];
		int con = 1;
		int temp = con;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=con;
			arr[i] = sum;
			temp-=1;
			if(temp == 0) {
				con++;
				temp = con;
			}
		}
		for (int i = 0; i < n; i++) {
			while(true) {
				int day = scanner.nextInt();
				if(day == 0)
					break;
				System.out.println(day + " " + arr[day-1]);
			}
			System.out.println();
		}
	}
}
//2
//
//10
//0
//
//10000
//1000
//0


//10 30
//
//10000 942820
//1000 29820