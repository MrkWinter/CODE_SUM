package com.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem2 {
	// ���ֲ����㷨 + �������
	// �ȼ���Ϊ maxtime /2 ʱ�� Ȼ�󲻶ϼ�С
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int len = scanner.nextInt(); // �ܵ�����

		Integer[][] time = new Integer[n][2];
		for (int i = 0; i < n; i++) {
			time[i][0] = scanner.nextInt() - 1;
			time[i][1] = scanner.nextInt();
		}
		// ��ʱ������
		Arrays.sort(time, (Integer[] o1, Integer[] o2) -> o1[1] - o2[1]);
		int left = 1;
		int right = len + time[0][1];
		int result = 0;
		int[][] area = new int[n][2];
		while (left <= right) {
			int midTime = (left + right) / 2;
			boolean isFull = true;
			// ���в��� ������Գ��� ��С ������ ��� �������һ�ο��ԵĽ��
			int k = 0;
			for (int i = 0; i <= n - 1 && midTime >= time[i][1]; i++, k++) {
				int j = midTime - time[i][1];
				// �ϲ�����
				area[k][0] = time[i][0] - j >= 0 ? time[i][0] - j : 0;
				area[k][1] = time[i][0] + j <= len - 1 ? time[i][0] + j : len - 1;
			}
			Arrays.sort(area, (int[] a1, int[] a2) -> a1[0] - a2[0]);
			for (int i = 0; i < area.length - 1; i++) {
				if (area[i + 1][0]-1 > area[i][1]) {
					isFull = false;
				}
			}
			if (!isFull) {
				left = midTime + 1;
			} else {
				right = midTime - 1;
				result = midTime;
			}
		}
		System.out.println(result);
	}
}
