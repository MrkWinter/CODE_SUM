package com.learn1;

public class Test2 {
	public static void main(String[] args) {
		System.out.println(getfe(39));
	}

	public static long getfe(int n) {
		long result = 0l;
		long num = 1l;
		for (int i = 1; i <= n; i++) {
			num = ((num *= i) % 1000000000l);
			result += num;
		}
		return result % 1000000000l;
	}
}