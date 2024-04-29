package com.learn7;

import java.util.HashMap;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Character, Character> hp = new HashMap<Character, Character>();
		hp.put('A', 'A');
		hp.put('E', '3');
		hp.put('H', 'H');
		hp.put('I', 'I');
		hp.put('J', 'L');
		hp.put('L', 'J');
		hp.put('M', 'M');
		hp.put('O', 'O');
		hp.put('S', '2');
		hp.put('T', 'T');
		hp.put('U', 'U');
		hp.put('V', 'V');
		hp.put('W', 'W');
		hp.put('X', 'X');
		hp.put('Y', 'Y');
		hp.put('Z', '5');
		hp.put('1', '1');
		hp.put('2', 'S');
		hp.put('3', 'E');
		hp.put('5', 'Z');
		hp.put('8', '8');
		while (scanner.hasNext()) {
			String str = scanner.next();
			char[] strArr = str.toCharArray();
			int len = strArr.length;
			boolean flag1 = true;
			for (int j = 0; j < len / 2 + 1; j++) {
				if (strArr[j] != strArr[len - j - 1]) {
					flag1 = false;
					break;
				}
			}
			// µÃµ½¾µÏñ
			for (int i = 0; i < strArr.length; i++) {
				Character c = hp.get(strArr[i]);
				if (c != null) {
					strArr[i] = c;
				}
			}

			boolean flag2 = true;
			for (int j = 0; j < len; j++) {
				if (str.charAt(j) != strArr[len - j - 1]) {
					flag2 = false;
					break;
				}
			}
			if(len == 1 && hp.get(str.charAt(0)) == null) {
				flag2 = false;
			}
			if (flag1 && flag2) {
				System.out.println(str + " -- is a mirrored palindrome.");
			} else if (!flag1 && flag2) {
				System.out.println(str + " -- is a mirrored string.");
			} else if (flag1 && !flag2) {
				System.out.println(str + " -- is a regular palindrome.");
			} else if (!flag1 && !flag2) {
				System.out.println(str + " -- is not a palindrome.");
			}
			System.out.println();
		}
	}
}
//NOTAPALINDROME
//ISAPALINILAPASI
//2A3MEAS
//ATOYOTA
//
//NOTAPALINDROME -- is not a palindrome.
//
//ISAPALINILAPASI -- is a regular palindrome.
//
//2A3MEAS -- is a mirrored string.
//
//ATOYOTA -- is a mirrored palindrome.

//NOTAPALINDROME -- is not a palindrome.
//ISAPALINILAPASI -- is a mirrored palindrome.
//2A3MEAS -- is not a palindrome.
//
//ATOYOTA -- is a mirrored palindrome.