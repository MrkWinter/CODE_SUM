package com.dataStract.unit2._08string;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int bf = KMP2("abcdefg", "cde");
		System.out.println(bf);
		int[] next = getNext("abcabc");
		System.out.println(Arrays.toString(next));
		
		
	}

	public static int BF(String ts, String ps) {
		char[] tsArr = ts.toCharArray();
		char[] psArr = ps.toCharArray();
		int tlen = tsArr.length - 1;
		int plen = psArr.length - 1;
		if (tlen < tlen)
			return -1;
		int j = 0;
		for (int i = 0; i <= tlen;) {
			if (tsArr[i] == psArr[j]) {
				j++;
				i++;
			} else {
				i -= j - 1;
				j = 0;
			}
			if (j == plen + 1)
				return i - j;
		}
		return -1;
	}

	// i为比较位置
	public static int BF2(String ts, String ps) {
		char[] tsArr = ts.toCharArray();
		char[] psArr = ps.toCharArray();
		int tlen = tsArr.length;
		int plen = psArr.length;
		if (tlen < plen || tlen <= 0 || plen <= 0)
			return -1;
		int i = 0;
		int j = 0;
		while (i < tlen && j < plen) {
			if (tsArr[i] == psArr[j]) {
				i++;
				j++;
			} else {
				i -= j - 1;
				j = 0;
			}
		}
		return j == plen ? i - j : -1;
	}

	public static int BF3(String ts, String ps) {
		char[] tsArr = ts.toCharArray();
		char[] psArr = ps.toCharArray();
		int tlen = tsArr.length;
		int plen = psArr.length;
		if (tlen < plen || tlen <= 0 || plen <= 0)
			return -1;
		int i = 0;
		int j = 0;
		// 字符串比较的索引要小于临界值
		while (i - j <= tlen - plen && j < plen) {
			if (tsArr[i] == psArr[j]) {
				i++;
				j++;
			} else {
				i -= j - 1;
				j = 0;
			}
		}
		return j == plen ? i - j : -1;
	}

	// i为起始比较位置 (较优)
	public static int BF4(String ts, String ps) {
		char[] tsArr = ts.toCharArray();
		char[] psArr = ps.toCharArray();
		int tlen = tsArr.length;
		int plen = psArr.length;
		if (tlen < plen || tlen <= 0 || plen <= 0)
			return -1;
		int i = 0;
		int j = 0;
		// 字符串比较的索引要小于临界值
		while (i <= tlen - plen && j < plen) {
			if (tsArr[i + j] == psArr[j]) {
				j++;
			} else {
				i += 1;
				j = 0;
			}
		}
		return j == plen ? i : -1;
	}

	public static int KMP(String text, String pattern) {
		char[] tsArr = text.toCharArray();
		char[] psArr = pattern.toCharArray();
		int[] next = getNext(pattern);
		int tlen = tsArr.length;
		int plen = psArr.length;
		int i = 0;
		int j = 0;
		if (tlen < plen || tlen <= 0 || plen <= 0)
			return -1;
		while (i - j <= tlen - plen && j < plen) {
			if (j < 0 || tsArr[i] == psArr[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return j == plen ? i - j : -1;
	}

	public static int KMP2(String text, String pattern) {
		char[] tsArr = text.toCharArray();
		char[] psArr = pattern.toCharArray();
		int[] next = getNext(pattern);
		int tlen = tsArr.length;
		int plen = psArr.length;
		int i = 0;
		int j = 0;
		if (tlen < plen || tlen <= 0 || plen <= 0)
			return -1;
		while (i <= tlen - plen && j < plen) {
			if (tsArr[i + j] == psArr[j]) {
				j++;
			} else {
				if(next[j] <= 0) {
					i+=1;
					j = 0;
				}else {
					i+=next[j]+1;
					j = next[j];
				}
			}
		}
		return j == plen ? i : -1;
	}

//	public static int[] getNext(String pattern) {
////		int[] next = new int[pattern.length()];
////		char[] pArr = pattern.toCharArray();
//////		next[0] = -1;
////		for (int i = 1; i < next.length; i++) {
////			int n = i;
////			while (pArr[i] != pArr[next[n]]) {
////				n = next[n];
////			}
////			next[i] = next[n] + 1;
////		}
////
////		return next;
//	}
	
	public static int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];
		char[] pArr = pattern.toCharArray();
		int i = 0;
		int n = -1;
		next[0] = -1;
		while(i < next.length-1) {
			if(n<0 || pArr[i] == pArr[n]) {
				next[++i] = ++n;
			} else {
				n = next[n];
			}
		}
		return next;
	}
	
	//next 优化
	public static int[] getNext2(String pattern) {
		int[] next = new int[pattern.length()];
		char[] pArr = pattern.toCharArray();
		int i = 0;
		int n = -1;
		next[0] = -1;
		while(i < next.length-1) {
			if(n<0 || pArr[i] == pArr[n]) {
				i++;
				n++;
				if(pArr[i] == pArr[n]) {
					next[i] = next[n];
				}else {
					next[i] = n;
				}
			} else {
				n = next[n];
			}
		}
		return next;
	}
}
