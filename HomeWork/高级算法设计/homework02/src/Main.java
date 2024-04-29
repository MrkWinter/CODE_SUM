/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 数据定义和初始化
        int[][] num = new int[7][27];
        for (int i = 1; i < 27; i++)
            num[1][i] = 1;
        num[1][0] = 26;

        // 求出index矩阵
        for (int len = 2; len < 7; len++) {
            int sum = 0, pre = num[len - 1][0];
            for (int first = 1; first < 27; first++) {
                pre -= num[len - 1][first];
                num[len][first] += pre;
                sum += pre;
            }
            num[len][0] = sum;
        }

        // 获得输出
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            String str = strings[i];
            int length = str.length();
            int index = 0;
            int ch = 0;
            for (int j = 1; j < length; j++)
                index += num[j][0];
            for (int j = length; j > 0; j--) {
                int tmp = str.charAt(length - j) - 'a' + 1;
                for (int letter = tmp - 1; letter > ch; letter--)
                    index += num[j][letter];
                ch = tmp;
            }
            System.out.println(index + 1);
        }
        sc.close();
    }
}







