package com.learn7;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String next = scanner.next();
			if(next.equals("end")) {
				break;
			}
			boolean flag = true;
			int len = next.length();
			for (int i = 0; i < len/2+1; i++) {
				if(next.charAt(i) != next.charAt(len-i-1) ) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(next + " is a palindrome!");
			} else {
				System.out.println(next + " is not a palindrome!");
			}
		}
	}
}
//abcba is a palindrome!
//abcdefcba is not a palindrome!