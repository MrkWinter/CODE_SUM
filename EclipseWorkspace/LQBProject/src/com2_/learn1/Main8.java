package com2_.learn1;

import java.util.Scanner;

public class Main8 {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String[] next = scanner.next().split("-");
			String[] data = next[0].split("/");
			String[] time = next[1].split(":");
			String[] newData = new String[3];
			String[] newTime = new String[3];
			newData[0] = data[1];
			newData[1] = data[2];
			newData[2] = data[0];
			newTime[1] = time[1];
			newTime[2] = time[2];
			String tail = "am";
			int hour = Integer.valueOf(time[0]);
			if (hour > 12) {
				hour -= 12;
				tail = "pm";
			} else if (hour == 12) {
				tail = "pm";
			} else if (hour == 0) {
				hour = 12;
			} 
			newTime[0] = String.valueOf(hour);
			System.out.println(newData[0] + "/" + newData[1] + "/" + newData[2] + "-" + newTime[0] + ":" + newTime[1]
					+ ":" + newTime[2] + tail);
		}
	}
}