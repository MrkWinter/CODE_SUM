package com.learn4;

import java.util.ArrayList;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Çó
		int maxS = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; maxS < 10000; i++) {
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
				}
			}
			if(flag) {
				list.add(i);
				maxS = i;
			}
		}
		while (true) {
			int num = scanner.nextInt();
			if(num == 0)
				break;
			int count = 0;
			int sum = 0;
			int bIndex = 0;
			for (int i = 0; i < list.size(); i++) {
				sum +=list.get(i);
				while(sum>num) {
					sum-=list.get(bIndex++);
				}
				if(sum == num) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
//41
//20
//0