package com.dataStract.unit2.digui;

public class Test {
	public static void main(String[] args) {
//		int d = fib(6);
//		System.out.println(d);
//		System.out.println(fib3(6));
//		System.out.println(fib3(6));
		hano(6, "a", "b", "c");

	}

	public static int fib(int n) {
		int[] fibArr = new int[n + 1];
		fibArr[1] = 1;
		fibArr[2] = 1;
		return fib1(n, fibArr);
	}

	private static int fib1(int n, int[] fibArr) {
		if (fibArr[n] == 0) {
			fibArr[n] = fib1(n - 1, fibArr) + fib1(n - 2, fibArr);
		}
		return fibArr[n];
	}

	public static int fib3(int n) {
		if (n <= 2)
			return 1;
		int b = 1;
		int e = 2;
		n -= 3;
		while (n-- > 0) {
			if (b < e)
				b = e + b;
			else
				e = e + b;
		}
		return Math.max(e, b);
	}

	public static int fib4(int n) {
		if (n <= 2)
			return 1;
		int[] fib = new int[2];
		fib[0] = fib[1] = 1;
		for (int i = 3; i <= n; i++) {
			fib[i & 1] = fib[(i - 1) & 1] + fib[(i - 2) & 1];
		}
		return fib[n & 1];
	}

	public int step(int n) {
		if (n == 1)
			return 1;
		if (n == 2) {
			return 2;
		}
		return step(n - 1) + step(n - 2);
	}

	public static void hano(int n, String a, String b, String c) {
		if (n == 1) {
			System.out.println(a + " -> " + c);
			return;
		}
		hano(n - 1, a, c, b);
		System.out.println(a + " -> " + c);
		hano(n - 1, b, a, c);
	}
}
