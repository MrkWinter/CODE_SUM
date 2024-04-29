package com.learn8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> hp = new HashMap<String, Integer>();
		hp.put("negative", -1);
		hp.put("zero", 0);
		hp.put("one", 1);
		hp.put("two", 2);
		hp.put("three", 3);
		hp.put("four", 4);
		hp.put("five", 5);
		hp.put("six", 6);
		hp.put("seven", 7);
		hp.put("eight", 8);
		hp.put("nine", 9);
		hp.put("ten", 10);
		hp.put("eleven", 11);
		hp.put("twelve", 12);
		hp.put("thirteen", 13);
		hp.put("fourteen", 14);
		hp.put("fifteen", 15);
		hp.put("sixteen", 16);
		hp.put("seventeen", 17);
		hp.put("eighteen", 18);
		hp.put("nineteen", 19);
		hp.put("twenty", 20);
		hp.put("thirty", 30);
		hp.put("forty", 40);
		hp.put("fifty", 50);
		hp.put("sixty", 60);
		hp.put("seventy", 70);
		hp.put("eighty", 80);
		hp.put("ninety", 90);
		hp.put("hundred", 100);
		hp.put("thousand", 1000);
		hp.put("million", 1000000);
		// 添加数字和对应的英文
		while (scanner.hasNext()) {
			String next = scanner.nextLine();
			if (next == "")
				break;
			ArrayList<Integer> numList = new ArrayList<Integer>();
			String[] split = next.split(" ");
			for (int i = 0; i < split.length; i++) {
				numList.add(hp.get(split[i]));
			}
			int temp = numList.get(0);
			if (temp == -1)
				temp = 0;
			int result = 0;
			for (int i = 1; i < numList.size(); i++) {
				Integer cur = numList.get(i);
				if (cur == 100) {
					temp -= numList.get(i - 1);
					temp += numList.get(i - 1) * cur;
				} else if (cur % 1000 == 0) {
					temp *= cur;
					result+=temp;
					temp = 0;
				} else {
					temp += cur;
				}
			}
			result +=temp;
			if (numList.get(0) == -1) {
				result = -result;
			}
			System.out.println(result);
		}
	}
}
