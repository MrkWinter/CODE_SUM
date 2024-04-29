package com2_.learn2;

import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String next = scanner.next();
			char[] arr = next.toCharArray();
			if(arr[0] == '0')
				break;
			int p = 0;
			int result = 0;
			for (int i = arr.length-1; i >= 0 ; i--) {
				result+= (int)(arr[i] -'0') * (Math.pow(2,p+1)-1);
				p++;
			}
			System.out.println(result);
		}
	}
}
