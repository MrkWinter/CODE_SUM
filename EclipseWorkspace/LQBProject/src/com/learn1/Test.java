package com.learn1;

public class Test {
	public static void main(String[] args) {
		int count = 10;
		int result = 126;
		while (count < 2023) {
			result += 1;
			int n = 0;
			// 如果是哈沙德数 count+1
			int cn1 = 0;
			n = result;
			cn1 += result % 2;
			while ((n = n / 2) != 0) {
				cn1 += n % 2;
			}
			int cn2 = 0;
			n = result;
			cn2 += result % 8;
			while ((n = n / 8) != 0) {
				cn2 += n % 8;
			}
			int cn3 = 0;
			n = result;
			cn3 += result % 10;
			while ((n=n / 10) != 0) {
				cn3 += n % 10;
			}
			int cn4 = 0;
			n = result;
			cn4 += result % 16;
			while ((n = n / 16) != 0) {
				cn4 += n % 16;
			}
			if (result % cn1 == 0 && result % cn2 == 0 && result % cn3 == 0 && result % cn4 == 0)
				count += 1;
		}
		System.out.println(result);
	}

	public static int feb(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 2;
		return feb(n - 1) + feb(n - 2);
	}

}

enum Season {
	SPRING("wang", 1), SUMMER("li", 3);

	private String name;
	private int num;

	private Season(String name, int num) {
		this.name = name;
		this.num = num;
	}

}