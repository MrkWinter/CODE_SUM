package com.learn2;

import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String s1Left = scanner.next();
			String s1Right = scanner.next();
			String s1Result = scanner.next();

			String s2Left = scanner.next();
			String s2Right = scanner.next();
			String s2Result = scanner.next();

			String s3Left = scanner.next();
			String s3Right = scanner.next();
			String s3Result = scanner.next();

			char[] arr = "ABCDEFGHIGKL".toCharArray();
			for (int j = 0; j < arr.length; j++) {
				String coin = String.valueOf(arr[j]);
				if ((s1Left.contains(coin) || s1Right.contains(coin)) && s1Result.equals("even"))
					continue;
				if ((s2Left.contains(coin) || s2Right.contains(coin)) && s2Result.equals("even"))
					continue;
				if ((s3Left.contains(coin) || s3Right.contains(coin)) && s3Result.equals("even"))
					continue;
				String coinWig = "";
				if (s1Left.contains(coin)) {
					coinWig = s1Result.equals("up") ? "heavy" : "light";
				} else if (s1Right.contains(coin)) {
					coinWig = s1Result.equals("down") ? "heavy" : "light";
				}

				if (s2Left.contains(coin)) {
					String re = s2Result.equals("up") ? "heavy" : "light";
					if (coinWig.equals(""))
						coinWig = re;
					else if (!coinWig.equals(re)) {
						continue;
					}
				} else if (s2Right.contains(coin)) {
					String re = s2Result.equals("down") ? "heavy" : "light";

					if (coinWig.equals(""))
						coinWig = re;
					else if (!coinWig.equals(re)) {
						continue;
					}
				}

				if (s3Left.contains(coin)) {
					String re = s3Result.equals("up") ? "heavy" : "light";

					if (coinWig.equals(""))
						coinWig = re;
					else if (!coinWig.equals(re)) {
						continue;
					}
				} else if (s3Right.contains(coin)) {
					String re = s3Result.equals("down") ? "heavy" : "light";

					if (coinWig.equals(""))
						coinWig = re;
					else if (!coinWig.equals(re)) {
						continue;
					}
				}
				System.out.println(coin + " is the counterfeit coin and it is " + coinWig + ".");
				break;
			}
		}

	}

//2
//ABCD EFGH even
//ABCI EFJK up
//ABIJ EFGH even
//ABCDEF GHIJKL up
//ABHLEF GDIJKC down
//CD HA even


//	K is the counterfeit coin and it is light.
//	L is the counterfeit coin and it is light.
}
