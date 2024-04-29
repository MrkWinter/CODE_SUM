package com.learn5;

import java.util.LinkedList;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int pass = 2;
			while (true) {
				LinkedList<Integer> queue = new LinkedList<Integer>();
				for (int i = 2; i < n + 1; i++) {
					queue.offer(i);
				}
				boolean flag = false;
				for (int i = 0; i < n - 2; i++) {
					int count = 1;
					while (true) {
						Integer poll = queue.poll();
						if (count % pass == 0) {
							if (poll == 2)
								flag = true;
							break;
						}
						queue.offer(poll);
						count++;
					}
					if (flag) {
						pass++;
						break;
					}
				}
				if (!flag)
					break;
			}
			System.out.println(pass);
		}
	}
}
//8
//9
//0