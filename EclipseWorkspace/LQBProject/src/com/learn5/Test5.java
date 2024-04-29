package com.learn5;

import java.util.LinkedList;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int pass = scanner.nextInt();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i < n + 1; i++) {
			queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int count = 1;
			int num = 0;
			while (true) {
				num = queue.poll();
				if(count++%pass ==0)
					break;
				queue.offer(num);
			}
			System.out.print(num + " ");
		}
	}
}
//10 3