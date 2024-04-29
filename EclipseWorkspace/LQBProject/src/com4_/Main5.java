package com4_;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		BigDecimal[] bigArr =  new BigDecimal[1000000];
		bigArr[0] = new BigDecimal("7");
		bigArr[1] = new BigDecimal("11");
		for (int i = 2; i < bigArr.length; i++) {
			bigArr[i] = bigArr[i-1].add(bigArr[i-2]);
		}
		
		BigDecimal three = new BigDecimal("3");
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(getFib(n).toString());
			if (bigArr[n].remainder(three).compareTo(BigDecimal.ZERO) == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private static BigDecimal getFib(int n) {
		BigDecimal[] bigD = new BigDecimal[2];
		bigD[0] = new BigDecimal("7");
		bigD[1] = new BigDecimal("11");
		if (n == 0)
			return bigD[0];
		if (n == 1)
			return bigD[1];
		for (int i = 2; i <= n; i++) {
			bigD[i % 2] = bigD[i % 2].add(bigD[(i + 1) % 2]);
		}
		return bigD[n % 2];
	}
}
