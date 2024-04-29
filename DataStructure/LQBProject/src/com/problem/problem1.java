package com.problem;

/*
 * 问题描述

哈沙德数是指在某个固定的进位制当中，可以被各位数字之和整除的正整数。
例如 126126 是十进制下的一个哈沙德数，因为 (126)10 mod (1+2+6)=0(126)10​mod(1+2+6)=0；
126126 也是八进制下的哈沙德数，因为 (126)10=(176)8(126)10​=(176)8​ ，(126)10mod 
 (1+7+6)=0(126)10​mod(1+7+6)=0；同时 126126 也是 1616 进制下的哈沙德数，
因为 (126)10=(7e)16(126)10​=(7e)16​ ，(126)10mod  (7+e)=0(126)10​mod(7+e)=0。
小蓝认为，如果一个整数在二进制、八进制、十进制、十六进制下均为哈沙德数，那么这个数字就是幸运数字，
第 11 至第 1010 个幸运数字的十进制表示为：1,2,4,6,8,40,48,72,120,126…1,2,4,6,8,40,48,72,120,126…。
现在他想知道第 20232023 个幸运数字是多少？你只需要告诉小蓝这个整数的十进制表示即可
 */
public class problem1 {

	public static void main(String[] args) {
		int result = 126;
		int count = 10;
		while(count < 2023) {
			result +=1;
			if(isHaNum(result,2) && isHaNum(result,8) && isHaNum(result,10) && isHaNum(result,16))
				count +=1;
		}
		System.out.println(result);
	}

	public static boolean isHaNum(int num, int hx) {
		int bx = num % hx;
		int n = num;
		while ((n = n / hx) != 0) {
			bx += n % hx;
		}
		return num % bx == 0;
	}
}
