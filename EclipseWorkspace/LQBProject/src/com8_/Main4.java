package com8_;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = i;
			arr[i][1] = scanner.nextInt();
		}
		Arrays.sort(arr, (int[] a1, int[] a2) -> a1[1] - a2[1]);
		boolean flag = true;
		int midIndex = n / 2;
		int mid = arr[midIndex][1];
		int left = midIndex - 1;
		int right = midIndex + 1;
		while (left >= 0 && right < n) {
			if (arr[left][1] == mid)
				left--;
			else if (arr[right][1] == mid)
				right++;
			else
				break;
		}
		if (midIndex - left > right - midIndex) {
			flag = false;
		}
		Arrays.sort(arr, (int[] a1, int[] a2) -> a1[0] - a2[0]);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1] >= mid) {
				arr[i][1] = 0;
			} else if (arr[i][1] == mid) {
				if (flag) {
					arr[i][1] = 0;
				} else {
					arr[i][1] = 1;
				}
			} else {
				arr[i][1] = mid - arr[i][1] + 1;
			}
			System.out.print(arr[i][1] + " ");
		}
		System.out.println();
	}
}
