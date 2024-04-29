package com.learn1;

import java.util.Scanner;

public class Test4 {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
////		2 1 7 4 5 3 8 6
//		int[] areaNum = new int[8];
//		for (int i = 0; i < 8; i++) {
//			areaNum[i] = scanner.nextInt();
//		}
//		int x1 = areaNum[0];
//		int y1 = areaNum[1];
//		int x2 = areaNum[2];
//		int y2 = areaNum[3];
//		int x3 = areaNum[4];
//		int y3 = areaNum[5];
//		int x4 = areaNum[6];
//		int y4 = areaNum[7];
//		// 包含
//		int area1 = (x2 - x1) * (y2 - y1);
//		int area2 = (x4 - x3) * (y4 - y3);
//		if ((x1 <= x3 && x4 <= x2 && y1 <= y3 && y4 <= y2) || (x3 <= x1 && x2 <= x4 && y3 <= y1 && y2 <= y4)) {
//			System.out.println((int) Math.abs(area1 - area2));
//			return;
//		}
//		// 互斥
//		if (x2 <= x3 || x4 <= x1 || y4 <= y1 || y2 <= y3) {
//			System.out.println(area1 + area2);
//			return;
//		}
//		// 有交集
//		if (x1 < x4 && y1 < y4 && x4 < x2 && y4 < y2) {
//			System.out.println(area1 + area2 - (x4 - x1) * (y4 - y1));
//		} else if (x2 < x3 && y1 < y4 && x1 < x3 && y4 < y2) {
//			System.out.println(area1 + area2 - (x3 - x2) * (y4 - y1));
//		} else if (x1 < x4 && y3 < y2 && x3 < x1 && y2 < y4) {
//			System.out.println(area1 + area2 - (x4 - x1) * (y2 - y3));
//		} else if (x3 < x2 && y3 < y2 && x2 < x4 && y2 < y4) {
//			System.out.println(area1 + area2 - (x2 - x3) * (y2 - y3));
//		}
//		return;
//	}

	public static void main(String[] args) {
//		2 1 7 4 5 3 8 6
		Scanner scanner = new Scanner(System.in);
		long x1 = scanner.nextInt();
		long y1 = scanner.nextInt();
		long x2 = scanner.nextInt();
		long y2 = scanner.nextInt();
		long x3 = scanner.nextInt();
		long y3 = scanner.nextInt();
		long x4 = scanner.nextInt();
		long y4 = scanner.nextInt();
		long area = (x2 - x1) * (y2 - y1) + (x4 - x3) * (y4 - y3);
		long overWeight = Math.max(0, Math.min(x2, x4) - Math.max(x1, x3));
		long overHight = Math.max(0, Math.min(y2, y4) - Math.max(y1, y3));
		if(overHight >0 && overWeight>0) {
			area -= overWeight * overHight;
		}
		System.out.println(area);
	}
	
	
}
