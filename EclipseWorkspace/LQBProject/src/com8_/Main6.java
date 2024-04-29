package com8_;

public class Main6 {
	public static boolean[] arr;

	public static void main(String[] args) {
		arr = new boolean[20210606];
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			arr[i] = flag;
		}
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (isTruePrim(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean isTruePrim(int num) {
		if (!arr[num])
			return false;
		while (num != 0) {
			if (!arr[num % 10])
				return false;
			num /= 10;

		}
		return true;
	}
}
