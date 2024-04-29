package com.learn1;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[scanner.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(getBuyNum(arr));

//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int[] arr = new int[n];
//		double max = 0;
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = scanner.nextInt();
//			if (max < arr[i]) {
//				max = arr[i];
//			}
//		}
//		LinkedList<Integer> buyQueue = new LinkedList<Integer>();
//		LinkedList<Integer> giftQueue = new LinkedList<Integer>();
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] >= (max) / 2.0) {  ！！！！
//				buyQueue.offer(arr[i]);
//			} else {
//				giftQueue.offer(arr[i]);
//			}
//		}
//		buyQueue.sort((t1, t2) -> t2 - t1);
//		giftQueue.sort((t1, t2) -> t2 - t1);
//		long buyCount = 0;
//		while (buyQueue.size() != 0 || giftQueue.size() != 0) {
//			if (buyQueue.size() >= 2) {
//				buyCount += buyQueue.poll();
//				int buy = buyQueue.poll();
//				buyCount += buy;
//				while (giftQueue.size() != 0) {
//					int gift = giftQueue.poll();
//					if (gift < buy / 2.0)
//						break;
//					buyQueue.offer(gift);
//				}
//			} else if (giftQueue.size() != 0) {
//				buyQueue.offer(giftQueue.poll());
//			} else {
//				buyCount += buyQueue.poll();
//			}
//		}
//		System.out.println(buyCount);
	}

	public static long getBuyNum(int[] arr) {
		Arrays.sort(arr);
		LinkedList<Integer> giftQueue = new LinkedList<Integer>();
		int len = arr.length - 1;
		boolean second = false;
		long result = 0;
		for (int i = len; i >= 0; i--) {
			if (!giftQueue.isEmpty() && giftQueue.peek() >= arr[i]) {
				giftQueue.poll();
			} else {
				result += arr[i];
				if (second) {
					giftQueue.offer(arr[i] / 2);
				}
				second = second ? false : true;
			}
		}
		return result;
	}

	public long minimum_cost(int[] prices) {
		long cost = 0;// 存放总花费金额，数值较大用long
		boolean second = false;// 判断是否为第二件购买的商品
		Queue<Integer> queue = new LinkedList<Integer>();// 创建队列存放可免费赠送商品的最大价格
		Arrays.sort(prices);// 对价格数组进行升序排序
		int len = prices.length - 1;// 存放数组最大下标，进行逆序访问
		while (len >= 0) {
			if (!queue.isEmpty() && prices[len] <= queue.peek()) {
				// 当队列不为空且当前商品满足免费赠送条件时，对赠送商品进行出队操作
				queue.poll();
			} else {
				// 当当前商品无法赠送时，进行购买操作
				cost += prices[len];
				if (second) {
					// 当商品是第二件购买的商品，符合赠送条件，入队可赠送价格
					queue.add(prices[len] / 2);
					second = false;
				} else {
					second = true;
				}
			}
			len--;
		}
		return cost;
	}

}
