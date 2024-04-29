package com.learn8;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			StringBuilder next = new StringBuilder(scanner.next());
			StringBuilder pattern = new StringBuilder(scanner.next());
			int count = 0;
			for (int j = 1; j < pattern.length(); j++) {
				String strA = pattern.substring(0, j);
				String strB = pattern.substring(j);
				int aIndex = 0;
				while (true) {
					aIndex = getstrA(strA, next, aIndex);
					if (aIndex == -1)
						break;
					count += getstrBCount(strB, next, aIndex);
				}
			}
			System.out.println(count);
		}
	}

	private static int getstrBCount(String strB, StringBuilder pattern, int aIndex) {
		int count = 0;
		String sub = " ";
		int index = 0;
		while (aIndex<pattern.length()) {
			sub = pattern.substring(aIndex);
			index = sub.indexOf(strB);
			if (index == -1)
				break;
			aIndex += index + 1;
			count += 1;
		}
		return count;
	}

	private static int getstrA(String strA, StringBuilder pattern, int aIndex) {
		String sub = pattern.substring(aIndex);
		int indexOf = sub.indexOf(strA);
		if (indexOf == -1)
			return -1;
		return indexOf+ aIndex + 1;
	}

}
