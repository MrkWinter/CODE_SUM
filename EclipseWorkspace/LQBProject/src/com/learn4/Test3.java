package com.learn4;

import java.util.HashMap;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
			hp.put(arr[i], 0);
		}
		int eNum = hp.size(); // ֪ʶ�����
		int curNum = 0; // ��ǰ֪ʶ�����
		int bePag = 0; // ��ʼҳ��
		int minCpag = Integer.MAX_VALUE; // ��С����ҳ
		for (int i = 0; i < arr.length; i++) {
			Integer e = hp.get(arr[i]);
			hp.put(arr[i], e + 1);
			if (curNum < eNum) {
				if (e == 0) {
					curNum++;
				}
				// ֪ʶ��+1
				// ����ǰ�� ��֤������eNum��֪ʶ��
			} else {
				while (true) {
					Integer eT = hp.get(arr[bePag]);
					if (eT <= 1)
						break;
					hp.put(arr[bePag++], eT - 1);
				}
				minCpag = Math.min(minCpag, i - bePag + 1);
			}
		}
		System.out.println(minCpag);
	}
}
