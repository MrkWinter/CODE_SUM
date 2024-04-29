package com2_.learn2;

import java.util.HashMap;
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Character, Integer> hp = new HashMap<Character,Integer>();
		hp.put('%',0);
		hp.put(')',1);
		hp.put('~',2);
		hp.put('@',3);
		hp.put('?',4);
		hp.put('\\',5);
		hp.put('$',-1);
		while(true) {
			char[] arr = scanner.next().toCharArray();
			if(arr[0] == '#')
				break;
			int result = 0;
			int p = 0;
			for (int i = arr.length-1; i >=0 ; i--,p++) {
				result += hp.get(arr[i]) * Math.pow(6, p);
			}
			System.out.println(result);
		}
	}
}
