package com.learn7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		HashMap<Character, String> hp = new HashMap();
		hp.put('A', ".-");
		hp.put('B', "-...");
		hp.put('C', "-.-.");
		hp.put('D', "-..");
		hp.put('E', ".");
		hp.put('F', "..-.");
		hp.put('G', "--.");
		hp.put('H', "....");
		hp.put('I', "..");
		hp.put('J', ".---");
		hp.put('K', "-.-");
		hp.put('L', ".-..");
		hp.put('M', "--");
		hp.put('N', "-.");
		hp.put('O', "---");
		hp.put('P', ".--.");
		hp.put('Q', "--.-");
		hp.put('R', ".-.");
		hp.put('S', "...");
		hp.put('T', "-");
		hp.put('U', "..-");
		hp.put('V', "...-");
		hp.put('W', ".--");
		hp.put('X', "-..-");
		hp.put('Y', "-.--");
		hp.put('Z', "--..");

		hp.put('_', "..--");
		hp.put('.', "---.");
		hp.put(',', ".-.-");
		hp.put('?', "----");
		HashMap<String, Character> ph = new HashMap();
		for (Map.Entry<Character, String> e : hp.entrySet()) {
			ph.put(e.getValue(), e.getKey());
		}
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			char[] arr = scanner.nextLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			int[] lenArr = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				String curStr = hp.get(arr[j]);
				lenArr[j] = curStr.length();
				sb.append(curStr);
			}
			int cur = 0;
			int len = lenArr.length - 1;
			for (int j = len; j >= 0; j--) {
				String getStr = sb.substring(cur, cur + lenArr[j]);
				cur += lenArr[j];
				Character c = ph.get(getStr);
				arr[len - j] = c;
			}
			System.out.print((i + 1) + ": ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
		}
	}
}
