package com.learn5;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int cur = scanner.nextInt();
			int t = scanner.nextInt();
			if (cur == 0 && t == 0)
				break;
			int count = 0;
			boolean flag = true;
			boolean[] com = new boolean[60];
			while (true) {
				if (cur == 0)
					break;
				if (com[cur]) {
					flag = false;
					break;
				}
				com[cur] = true;
				cur = (cur + cur * t) % 60;
				count += 1;
			}
			if (flag)
				System.out.println(count);
			else
				System.out.println("Impossible");
		}
	}
}
//59 59
//59 58
//0 0

//1
//Impossible