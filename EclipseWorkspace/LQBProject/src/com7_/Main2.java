package com7_;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0) {
				break;
			}
			int[] arr = new int[n];
			boolean[] isChiose = new boolean[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			dfs(-1, list, arr);
			System.out.println();
		}
	}

	private static void dfs(int index, ArrayList<Integer> list, int[] arr) {
		if (list.size() == 6) {
			for(Integer c : list) {
				System.out.print(c + " ");
			}
			System.out.println();
			return;
		}
		for (int i = index+1; i < arr.length; i++) {
			list.add(arr[i]);
			dfs(i,list,arr);
			list.remove(list.size()-1);
		}
	}
}


