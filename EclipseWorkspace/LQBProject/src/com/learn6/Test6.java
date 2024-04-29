package com.learn6;

import java.util.HashMap;
import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Character, Character> hp = new HashMap<Character, Character>();
		// µÚÒ»ÐÐ
		hp.put('B', '1');
		hp.put('F', '1');
		hp.put('P', '1');
		hp.put('V', '1');

		hp.put('C', '2');
		hp.put('J', '2');

		hp.put('G', '2');
		hp.put('K', '2');
		hp.put('Q', '2');
		hp.put('S', '2');
		hp.put('X', '2');
		hp.put('Z', '2');

		hp.put('D', '3');
		hp.put('T', '3');
		hp.put('L', '4');
		hp.put('M', '5');

		hp.put('N', '5');

		hp.put('R', '6');
		hp.put('A', ' ');
		hp.put('E', ' ');
		hp.put('I', ' ');
		hp.put('O', ' ');
		hp.put('U', ' ');
		hp.put('H', ' ');
		hp.put('W', ' ');
		hp.put('Y', ' ');
		while (scanner.hasNext()) {
			char[] arr = scanner.nextLine().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (i + 1 >= arr.length || hp.get(arr[i]) != hp.get(arr[i + 1]))
					arr[i] = hp.get(arr[i]);
				else 
					arr[i] =  ' ';
			}
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]!=' ')
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
}
