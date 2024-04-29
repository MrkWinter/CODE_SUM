package com5_;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			PriorityQueue<Double> heap = new PriorityQueue<Double>((Double d1 ,Double d2) -> -d1.compareTo(d2));	
			for (int i = 0; i < n; i++) {
				heap.offer(scanner.nextDouble());
			}
			while (heap.size() > 1) {
				double t1 = heap.poll();
				double t2 = heap.poll();
				double s1 = 2 * Math.sqrt(t1 * t2);
				heap.add(s1);
			}
			System.out.printf("%.3f\n",heap.poll());
		}
	}
}
