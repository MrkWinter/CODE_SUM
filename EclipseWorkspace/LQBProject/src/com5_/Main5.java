package com5_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			int c = scanner.nextInt();
			if (n == 0 && c == 0)
				break;
			ArrayList<int[]> list = new ArrayList();
			for (int i = 0; i < n; i++) {
				int w = scanner.nextInt();
				int v = scanner.nextInt();
				list.add(new int[] { w, v });
			}
			list.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					double g1 = o1[1] / (double) o1[0];
					double g2 = o2[1] / (double) o2[0];
					if (g1 > g2) {
						return -1;
					} else if (g1 < g2) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			int curC = 0;
			double sumV = 0;
			for (int i = 0; i < list.size(); i++) {
				int[] o = list.get(i);
				if(curC +o[0]<c ) {
					curC += o[0];
					sumV +=o[1];
				} else if(curC + o[0] > c) {
					sumV +=o[1]/(double)o[0] * (c-curC);
					curC =  c;
					break;
				} else {
					curC += o[0];
					sumV +=o[1];
					break;
				}
			}
			System.out.printf("%.2f",sumV);
		}
	}
}
