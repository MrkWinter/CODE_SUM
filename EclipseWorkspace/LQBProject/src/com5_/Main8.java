package com5_;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		PriorityQueue<Long> heap = new PriorityQueue<Long>((Long l1,Long l2) -> -l1.compareTo(l2));
		for (int i = 0; i < n; i++) {
			long temp = scanner.nextLong();
			if(temp <0) {
				temp = -temp;
			}
			heap.offer(temp);
		}
		long result = 1;
		for (int i = 0; i < k; i++) {
			result *= heap.poll();
		}
		result%=(long)(Math.pow(10, 9)+9);
		System.out.println(result);
	}
}
//999100009
//9999910009