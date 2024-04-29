package com.learn5;

import java.util.LinkedList;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		while (true) {
			int n = scanner.nextInt();
			int pass = scanner.nextInt();
			if (n == 0 && pass == 0)
				break;
			for (int i = 1; i < n + 1; i++) {
				queue.offer(i);
			}
			for (int i = 0; i < n - 1; i++) {
				int count = 1;
				while (true) {
					Integer poll = queue.poll();
					if (count % pass != 0) {
						queue.offer(poll);
					} else {
						break;
					}
					count++;
				}
			}
			System.out.println(queue.poll());
		}
	}
}
//8 4
//0 0