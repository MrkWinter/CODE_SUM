package com.learn5;

import java.util.LinkedList;
import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 先进行淘汰
		while (true) {
			int n = scanner.nextInt();
			int pass = scanner.nextInt();
			int yu = scanner.nextInt();
			if (n == 0 && pass == 0 && yu == 0)
				break;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			for (int i = 1; i < n + 1; i++) {
				queue.offer(i);
			}
			while (!queue.isEmpty()) {
				int count = 1;
				int num = 0;
				while (true) {
					num = queue.poll();
					if (count++ % pass == 0)
						break;
					queue.offer(num);
				}
				if (num == yu) {
					break;
				}
			}
			// 保存淘汰后数据
			if (queue.isEmpty())
				System.out.println(yu);
			int len = queue.size() + 1;
			int[] arr = new int[len];
			for (int i = 0; i < len - 1; i++) {
				arr[i] = queue.poll();
			}
			arr[len - 1] = yu;
			// 枚举遍历
			int result = 0;
			for (int i = 0; i < len - 1; i++) {
				for (int j = i; j < len + i; j++) {
					queue.offer(arr[j % len]);
				}
				queue.poll();
				while (!queue.isEmpty()) {
					int count = 1;
					int num = 0;
					while (true) {
						num = queue.poll();
						if (count++ % pass == 0)
							break;
						queue.offer(num);
					}
					if (num == yu) {
						break;
					}
				}
				if (queue.isEmpty()) {
					result = arr[i];
					break;
				}
				queue.clear();
			}
			System.out.println(result);
		}
	}
}
//8 4 1
//1000 1 1
//0 0 0