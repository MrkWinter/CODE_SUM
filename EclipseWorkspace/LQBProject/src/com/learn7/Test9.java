package com.learn7;

import java.util.HashSet;
import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String next = scanner.next();
			char[] arr = next.toCharArray();
			if (arr[0] == '*')
				break;
			boolean flag = true;
			for (int i = 1; i < arr.length - 1; i++) {
				HashSet<String> hashSet = new HashSet<String>();
				for (int j = 0; j < arr.length - i; j++) {
					String temp = arr[j] + "" + arr[j + i];
					if (hashSet.contains(temp)) {
						flag = false;
						break;
					}else {
						hashSet.add(temp);
					}
				}
				if(!flag)
					break;
			}
			if(flag)
				System.out.println(next + " is surprising.");
			else 
				System.out.println(next + " is NOT surprising.");

		}
	}
}
//ZGBG
//BCBABCC
//*

//
//ZGBG is surprising.
//BCBABCC is NOT surprising.