package com.learn5;

import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			char[] arr = scanner.next().toCharArray();
			if (arr[0] == '#')
				break;
			int total = arr.length;
			double in = getInNum(arr);
			int result = (int) ((in / total) * 100);
			System.out.println(result);
		}
	}

	private static double getInNum(char[] arr) {
		int[] proArr = new int[arr.length];
		double result = 0;
		for (int i = 0; i < proArr.length; i++) {
			if (arr[i] == '.') {
				result += 1;
			} else if (arr[i] == '_') {
				result += 0;
			} else if (arr[i] == '/') {
				int cur = i;
				while(true) {
					cur--;
					if(cur <0 || arr[cur] == '.') {
						result+=1;
						break;
					}
					if(arr[cur] == '|' || arr[cur] == '\\' || arr[cur] == '/') {
						break;
					}
				}
			} else if (arr[i] == '\\') {
				int cur = i;
				while(true) {
					cur++;
					if(cur >=arr.length || arr[cur] == '.') {
						result+=1;
						break;
					}
					if(arr[cur] == '|' || arr[cur] == '\\' || arr[cur] == '/') {
						break;
					}
				}
			} else if(arr[i] == '|') {
				int cur = i;
				while(true) {
					cur--;
					if(cur <0 || arr[cur] == '.') {
						result+=0.5;
						break;
					}
					if(arr[cur] == '|' || arr[cur] == '\\' || arr[cur] == '/') {
						break;
					}
				}
				cur = i;
				while(true) {
					cur++;
					if(cur >=arr.length || arr[cur] == '.') {
						result+=0.5;
						break;
					}
					if(arr[cur] == '|' || arr[cur] == '\\' || arr[cur] == '/') {
						break;
					}
				}
			}
		}
		return result;
	}
}
///\.|__/\.
//_._/\_|.__/\./\_
//#