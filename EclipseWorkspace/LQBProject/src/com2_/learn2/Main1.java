package com2_.learn2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int num = scanner.nextInt();
			if(num  ==  0)
				break;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 2; i <= 16; i++) {
				if(isPalin(num,i)) {
					list.add(i);
				}
			}
			if(list.size()>0) {
				StringBuilder sb = new StringBuilder();
				for(int i: list) {
					sb.append(" " + i);
				}
				System.out.println("Number "+ num + " is palindrom in basis" + sb);
			} else {
				System.out.println("Number "+ num + " is not a palindrom");
			}
		}
	}

	private static boolean isPalin(int num, int sx) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(num!=0) {
			list.add(num%sx);
			num/=sx;
		}
		boolean isPal = true;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if(list.get(i)!=list.get(size-i-1)) {
				isPal = false;
				break;
			}
		}
		return isPal;
	}
}

