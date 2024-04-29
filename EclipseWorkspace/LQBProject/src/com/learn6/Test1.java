package com.learn6;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Stack<Integer>[] stack = new Stack[4];
		for (int i = 1; i < stack.length; i++) {
			stack[i] = new Stack<Integer>();
		}
		for (int i = 0; i < n; i++) {
			int blocks = scanner.nextInt();
			int times = scanner.nextInt();
			for (int j = blocks; j > 0; j--) {
				stack[1].push(j);
			}
			boolean flag = false; // 是否忽略后面步骤
			for (int j = 1; j <= times; j++) {
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				if (flag)
					continue;
				Integer pop = stack[from].pop();
				if (!stack[to].isEmpty() && pop > stack[to].peek()) {
					// 错误 输出当前-次数
					System.out.println(-j);
					flag = true;
				}
				stack[to].push(pop);
				if (to == 3 && stack[to].size() == blocks) {
					// j步移动成功
					System.out.println(j);
					flag = true;
				}
			}
			if (!flag) {
				System.out.println(0);
			}
			for (int j = 1; j < stack.length; j++) {
				stack[j].clear();
			}
		}
	}
}
//3

//2 3
//1 2
//1 3
//2 3

//2 3
//1 2
//1 3
//3 2

//2 3
//1 3
//1 2
//3 2



