package com.learn3;

public class Test2 {
	public static void main(String[] args) {
		int[] arr = new int[1000001];
		int len = arr.length;
		int selfNum = 0;
		for (int i = 1; i < len; i++) {
			if (arr[i] == 0)
				System.out.println(i);
			selfNum = getSelfNum(i);
			if(selfNum<len)
				arr[selfNum] = 1;
		}
	}

	private static int getSelfNum(int i) {
		int sum = 0;
		int ord = i;
		while(i!=0) {
			sum+=i%10;
			i/=10;
		}
		return ord + sum;
	}
}
