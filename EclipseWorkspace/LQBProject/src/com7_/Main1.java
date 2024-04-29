package com7_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n  = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			char[] arr = scanner.nextLine().toCharArray();
			Arrays.sort(arr);
			boolean[] isUse = new boolean[arr.length];
			ArrayList<Character> list = new ArrayList<Character>();
			dfs(list,arr,isUse);
		}
	}

	private static void dfs(ArrayList<Character> list, char[] arr, boolean[] isUse) {
		if(list.size() == arr.length) {
			for(Character c: list) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i = 0; i < arr.length; i++) {
			if(isUse[i])
				continue;
			if(hashSet.contains(arr[i]))
				continue;
			hashSet.add(arr[i]);
			isUse[i] = true;
			list.add(arr[i]);
			dfs(list,arr,isUse);
			list.remove(list.size()-1);
			isUse[i] = false;
		}
	}
}
