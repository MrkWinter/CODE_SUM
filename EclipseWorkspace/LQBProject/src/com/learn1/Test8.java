package com.learn1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] pole = new int[n];
		for (int i = 0; i < pole.length; i++) {
			pole[i] = scanner.nextInt();
		}
		int[][] door = new int[n][2];
		for (int i = 0; i < door.length-1; i++) {
			door[i][0] = scanner.nextInt();
			door[i][1] = scanner.nextInt();
		}
		double[][] path = new double[2][n];
		path[1][0] = door[0][0]/0.7;
		for (int i = 1; i < path[0].length; i++) {
			path[0][i] = Math.min(path[0][i-1] + pole[i] - pole[i-1], path[1][i-1] + door[i-1][1]/1.3);
			double time = path[1][i-1];
			double hight = door[i-1][1]- door[i][0];
			if(hight >0) {
				time += hight/1.3;
			} else if(hight <0) {
				time += (-hight)/0.7;
			}
			path[1][i] = Math.min(path[0][i] + door[i][0]/0.7,time);
		}
		
        System.out.printf("%.2f",path[0][n-1] +pole[0]);
//
//		double result = new BigDecimal(path[0][n-1]).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//		System.out.println(result + pole[0]);
		
	}
}
