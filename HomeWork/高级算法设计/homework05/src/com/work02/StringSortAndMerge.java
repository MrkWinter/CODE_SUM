package com.work02;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class StringSortAndMerge {
    public static void bubbleSort(String[] strings) {
        int n = strings.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (strings[j].compareTo(strings[j + 1]) > 0) {
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }
    }

    public static String mergeStrings(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"ab", "b", "abcd", "abd", "ef", "g", "cm", "c"};

        bubbleSort(strings);

        System.out.println("Sorted strings: " + Arrays.toString(strings));

        String mergedString = mergeStrings(strings);
        System.out.println("Merged string: " + mergedString);
    }
}
