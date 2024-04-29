package com2_.learn1;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String[] nextBegin = scanner.next().split(":");
			String[] nextEnd = scanner.next().split(":");
			int hour = (Integer.valueOf(nextEnd[0]) - Integer.valueOf(nextBegin[0]));
			int second = (Integer.valueOf(nextEnd[1]) - Integer.valueOf(nextBegin[1]));
			int sec = Integer.valueOf(nextEnd[2]) - Integer.valueOf(nextBegin[2]);
			if(sec <0) {
				sec+=60;
				second-=1;
			}
			if(second< 0) {
				second+=60;
				hour-=1;
			}
			System.out.println(hour*3600 +second*60 + sec);
		}
	}
}
