package com.learn6;

import java.util.HashMap;
import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] ord = scanner.nextLine().toCharArray();
		char[] rod = scanner.nextLine().toCharArray();
		HashMap<Character, Character> hp = new HashMap();
		for (int i = 0; i < rod.length; i++) {
			hp.put(ord[i], rod[i]);
		}
		for (int i = 0; i < rod.length; i++) {
			System.out.print(rod[i]);
		}
		System.out.println();
		for (int i = 0; i < ord.length; i++) {
			System.out.print(ord[i]);
		}
		System.out.println();
		while (scanner.hasNext()) {
			char[] cur = scanner.nextLine().toCharArray();
			for (int i = 0; i < cur.length; i++) {
				Character c = hp.get(cur[i]);
				if (c != null) {
					cur[i] = c;
				}
			}
			for (int i = 0; i < cur.length; i++) {
				System.out.print(cur[i]);
			}
			System.out.println();
		}
	}
}
//abcdefghijklmnopqrstuvwxyz
//zyxwvutsrqponmlkjihgfedcba
//Shar's Birthday:
//The birthday is October 6th, but the party will be Saturday,