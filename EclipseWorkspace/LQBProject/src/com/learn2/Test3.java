package com.learn2;

public class Test3 {
	public static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			//10进制
			int dec = getSumByBase(i, 10);
			//12进制
			int deo = getSumByBase(i, 12);
			//16进制
			int hex = getSumByBase(i, 16);
			if(dec == deo && deo == hex)
				System.out.println(i);
		}
	}
	public static int  getSumByBase(int num,int n) {
		int result = 0;
		while(num!=0) {
			result+=num%n;
			num/=n;
		}
		return result;
	}
}

