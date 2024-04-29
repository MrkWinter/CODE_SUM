package com2_.learn2;

import java.util.Scanner;

public class Main7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int num = scanner.nextInt();
			if (num == 0)
				break;
			for (int i = 0; i < 32; i += 2) {
				boolean n1 = false;
				boolean n2 = false;
				if ((num & (1 << i)) > 0) {
					n1 = true;
				}
				if ((num & (1 << i + 1)) > 0) {
					n2 = true;
				}
				if (n1) {
					num |= 1 << (i + 1);
				} else {
					num &= ~(1 << (i + 1));
				}
				if (n2) {
					num |= 1 << (i);
				} else {
					num &= ~(1 << (i));
				}
			}
			System.out.println(num);
		}
	}
}
