package com.learn7;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			char[] arr = scanner.nextLine().toCharArray();
			ArrayList<Character> resultList = new ArrayList<Character>();
			int i = 0;
			boolean flag = true;
			while (true) {
				if (i >= arr.length)
					break;
				int count = 1;
				while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
					if (!flag) {
						resultList.add('1');
						flag = true;
					}
					count++;
					i++;
				}
				if (count > 1) {
					if (arr[i] == '1') {
						for (int j = 0; j < count; j++) {
							resultList.add('1');
							resultList.add('1');
						}
					} else {
						resultList.add((count + "").charAt(0));
						resultList.add(arr[i]);
					}
				} else {
					if (flag) {
						resultList.add('1');
						flag = false;
					}
					resultList.add(arr[i]);
					if (arr[i] == '1')
						resultList.add(arr[i]);
				}
				i++;
			}
			if (!flag) {
				resultList.add('1');
				flag = false;
			}
			for (Character c : resultList) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
//AAAAAABCCCC
//12344

//6A1B14C
//11123124