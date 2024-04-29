package com.learn6;

import java.util.ArrayList;
import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			int[] arr = new int[num];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scanner.nextInt();
			}
			ArrayList<Character> list = new ArrayList<Character>();
			for (int j = 0; j < arr.length; j++) {
				int c = arr[j] - list.size() + j;
				for (int k = 0; k < c ; k++) {
					list.add('(');
				}
				list.add(')');
			}
			ArrayList<Integer> result = new ArrayList<Integer>();
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j) =='(')
					continue;
				int cur = j;
				int yu = 0;
				int count = 0;
				while(cur>=0) {
					if(list.get(cur) == ')') {
						yu++;
						count++;
					} else if(list.get(cur) == '(' ) {
						yu--;
						if(yu == 0) {
							result.add(count);
							break;
						}
					}
					cur--;
				}
			}
			for(int r :result) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}
