package com8_;

import java.math.BigDecimal;

public class Main2 {
	public static void main(String[] args) {
		BigDecimal cur = new BigDecimal("2022");
		BigDecimal add = new BigDecimal("1");
		int count = 0;
		int len = 0;
		char[] cArr = null;
		for (int i = 2022; i <= 2022222022; i++) {
			boolean flag = true;
			cArr = cur.toString().toCharArray();
			int curNum = 0;
			len = cArr.length;
			for (int j = 0; j < len / 2; j++) {
				int left = cArr[j];
				int right = cArr[len - j - 1];
				if (left != right || left < curNum) {
					flag = false;
					break;
				}
				curNum = left;
			}
			if (flag)
				count++;
			cur = cur.add(add);
		}
		System.out.println(count);
	}
}
//8241