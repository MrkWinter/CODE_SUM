package com.learn2;

import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("n e");
		System.out.println("- ------");
		double sum = 0.0f;
		double sub = 1.0;
		for (int i = 0; i <= 9; i++) {
			sub *= i;
			if (sub == 0)
				sub = 1.0;
			sum += 1.0 / sub;
			String formattedNum = String.format("%.10g", sum);
			formattedNum = formattedNum.replaceAll("\\.?0*$", "");
			System.out.print(i + " " + formattedNum);
			if(i<9)
				System.out.println();
		}
	}
}
