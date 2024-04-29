package com.learn6;

import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			char[] arr = scanner.nextLine().toCharArray();
			if(arr[0] == '#')
				break;
			long sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == ' ')
					continue;
				sum += ((int)arr[i]-64)* (i+1);
			}
			System.out.println(sum);
		}
	}
}
//ACM
//REGIONAL PROGRAMMING CONTEST
//#