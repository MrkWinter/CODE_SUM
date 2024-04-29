package com.dataStract.unit1._01fuzadu;

public class Main {
	public static void main(String[] args) {
System.out.println(fib(32));
System.out.println(fib2(32));
	}

	public static int fib(int n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}
	public static int fib2(int n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		int a1 = 0;
		int a2 = 1;
		for (int i = 2; i <= n-1; i++) {
			int sum = a1 + a2;
			a1 = a2;
			a2 = sum;
		}
		return a2;
	}
}
