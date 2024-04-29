package com6_;

import java.util.ArrayList;
import java.util.Scanner;

public class Main6 {
	private static boolean isFind = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String[] next = scanner.nextLine().split(" ");
			if (next[0].equals("0") && next[1].equals("END"))
				break;
			int target = Integer.valueOf(next[0]);
			char[] arr = next[1].toCharArray();
			ArrayList<Character> list = new ArrayList<Character>();
			isFind = false;
			for (int i = arr.length-1; i >= 0; i--) {
				dfs(arr[i], target, arr, list);
				if (isFind)
					break;
				list.clear();
			}
			if (isFind) {
				for (Character c : list) {
					System.out.print(c);
				}
				System.out.println();
			} else {
				System.out.println("no solution");
			}
		}
	}

	private static void dfs(char c, int target, char[] arr, ArrayList<Character> list) {
		list.add(c);
		if (list.size() == 5) {
			if (computed(list) == target)
				isFind = true;
				return;
		}
		for (int i = arr.length-1; i >=0; i--) {
			if (!list.contains(arr[i])) {
				dfs(arr[i], target, arr, list);
				if (isFind) {
					return;
				}
				list.remove(list.size()-1);
			}
		}

	}

	private static int computed(ArrayList<Character> list) {
		int v = list.get(0) - 'A' + 1;
		int w = list.get(1) - 'A' + 1;
		int x = list.get(2) - 'A' + 1;
		int y = list.get(3) - 'A' + 1;
		int z = list.get(4) - 'A' + 1;
		return (int) (v - Math.pow(w, 2) + Math.pow(x, 3) - Math.pow(y, 4) + Math.pow(z, 5));
	}
}
//CKGDBAEFHIJL