package com;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial1(4));
        System.out.println(factorial2(4));

    }

    public static int factorial1(int n) {
        if (n == 0)
            return 0;
        int ret = 1;
        for (int i = n; i > 0; i--) {
            ret *= i;
        }
        return ret;
    }

    public static int factorial2(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return n * factorial2(n - 1);
    }
}
