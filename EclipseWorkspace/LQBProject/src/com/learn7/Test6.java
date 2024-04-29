package com.learn7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            
            String result = findShortestString(a, b);
            System.out.println(result);
        }
        
        scanner.close();
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static String findShortestString(String a, String b) {
        String shortestString = "";
        int minLength = Integer.MAX_VALUE;
        List<String> validStrings = new ArrayList<>();

        for (int i = 0; i <= a.length(); i++) {
            String x1 = a.substring(0, i) + b + a.substring(i);
            if (isPalindrome(x1) && !isPalindrome(a)) {
                if (x1.length() < minLength) {
                    shortestString = x1;
                    minLength = x1.length();
                }
            }

            String x2 = b.substring(0, i) + a + b.substring(i);
            if (isPalindrome(x2) && !isPalindrome(b)) {
                if (x2.length() < minLength) {
                    shortestString = x2;
                    minLength = x2.length();
                }
            }
        }

        if (shortestString.isEmpty()) {
            return "No Solution.";
        }

        for (String str : validStrings) {
            if (str.equals(shortestString)) {
                return str;
            }
        }

        return shortestString;
    }
}
