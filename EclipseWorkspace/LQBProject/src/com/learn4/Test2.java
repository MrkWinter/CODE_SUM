package com.learn4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		int k = scanner.nextInt();
		Topic[] arr = new Topic[n];
		for (int i = 0; i < n; i++) {
			int time = scanner.nextInt();
			int id = scanner.nextInt();
			arr[i] = new Topic(time,id );
		}
		Arrays.sort(arr, (t1, t2) -> t1.time - t2.time);
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		Set<Integer> topId = new HashSet<Integer>();
		int beginIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			Integer knum = hp.get(arr[i].id);
			if (knum == null) {
				hp.put(arr[i].id, 0);
				knum = 0;
			}
			while (arr[i].time - arr[beginIndex].time >= d) {
				Integer newK = hp.get(arr[beginIndex].id) - 1;
				hp.put(arr[beginIndex++].id, newK);
			}
			knum = hp.get(arr[i].id);
			if (arr[i].time - arr[beginIndex].time < d) {
				if (knum + 1 >= k) {
					topId.add(arr[i].id);
				} 
				hp.put(arr[i].id, knum + 1);
			}
		}
		Object[] array = topId.toArray();
		Arrays.sort(array);
		for (Object id : array) {
			System.out.println(id);
		}
	}

	public static class Topic {
		int time;
		int id;

		public Topic(int time, int id) {
			super();
			this.time = time;
			this.id = id;
		}

	}
}
//7 10 2
//0 1
//0 10
//10 10
//10 1
//9 1
//100 3
//100 3