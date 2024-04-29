package com8_;

public class Main1 {
	public static void main(String[] args) {
		int result = 20;
		for (int i = 0; i < 21; i++) {
			result = (result%7)*(20%7);
		}
		System.out.println(result);
	}
}
// 7