package com.learn2;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			int curInd = 0;
			StringBuffer curRes = new StringBuffer("");
			while(num!=0) {
				if(num%2 == 1)
					curRes.append(" " + curInd);
				curInd +=1;
				num/=2;
			}
			String trim = curRes.toString().trim();
			System.out.println(trim);
		}
	}
}
