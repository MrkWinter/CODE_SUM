package com;

import java.util.ArrayList;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class FindHalfSet {
    public static void main(String[] args) {
        ArrayList<Integer> result = findHalfSet(6);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static ArrayList<Integer> findHalfSet(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(num);
        getHalfSet(num, Integer.toString(num), result);
        return result;
    }

    public static void getHalfSet(int num, String temp, ArrayList<Integer> result) {
        for (int i = 1; i <= num / 2; i++) {
            String strNum = i + temp;
            result.add(Integer.parseInt(strNum));
            getHalfSet(i, strNum, result);
        }
    }
}
