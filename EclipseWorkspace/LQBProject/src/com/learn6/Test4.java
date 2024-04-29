package com.learn6;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String begin = scanner.next();
			if(begin.equals("ENDOFINPUT")) {
				break;
			}
			scanner.nextLine();
			char[] arr = scanner.nextLine().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]>=65 && arr[i]<=90) {
					arr[i] = (char) (arr[i]-5<65?arr[i] + 21:arr[i]-5);
				}
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			String end = scanner.next();
		}
	}
}
//START
//NS BFW, JAJSYX TK NRUTWYFSHJ FWJ YMJ WJXZQY TK YWNANFQ HFZXJX
//END
//ENDOFINPUT