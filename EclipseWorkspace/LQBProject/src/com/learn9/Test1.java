package com.learn9;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String nextLine = scanner.nextLine();
			String[] split = nextLine.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < split.length; i++) {
				String cur = split[i];
				if (cur.equals("1")) {
					split[i] = "";
				} else if (cur.equals("-1")) {
					split[i] = "-";
				}
			}
			boolean first = true;
			for (int i = 0; i < split.length; i++) {
				if (split[i].equals("0"))
					continue;
				if (first) {
					if (i == split.length - 1) {
						// 0次方
						sb.append(split[i]);
					} else if (i == split.length - 2) {
						// 1次方
						sb.append(split[i] + "x");
					} else {
						sb.append(split[i] + "x^" + (8 - i));
					}
					first = false;
				} else {
					if (split[i].charAt(0) == '-') {
						split[i] = split[i].substring(1);
						//为减法
						sb.append(" - ");
					} else {
						sb.append(" + ");
					}

					if (i == split.length - 1) {
						// 0次方
						sb.append(split[i]);
					} else if (i == split.length - 2) {
						// 1次方
						sb.append(split[i] + "x");
					} else {
						sb.append(split[i] + "x^" + (8 - i));
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
