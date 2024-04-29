package com.work05;

import java.util.Map;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class PowMax {
    public static void main(String[] args) {
        int max = getMax(10);
        System.out.println(max);
    }
    public static int getMax(int n) {
        int i = 1;
        while (Math.pow(n, i)<1000) {
            i++;
        }
        return i-1;
    }
}
