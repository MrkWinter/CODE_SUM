package com.work02;

/**
 * @author MrkWinter
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeArrays {
    public static void merge(List<Integer> A, List<Integer> B) {
        int i = A.size() - 1;
        int j = B.size() - 1;
        int k = A.size() + B.size() - 1;
        for (int l = 0; l <= j; l++) {
            A.add(0);
        }
        while (i >= 0 && j >= 0) {
            if (A.get(i) > B.get(j)) {
                A.set(k, A.get(i));
                i--;
            } else {
                A.set(k, B.get(j));
                j--;
            }
            k--;
        }
        //A有序 不需考虑
        while (j >= 0) {
            A.set(k, B.get(j));
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        List<Integer> B = new ArrayList<>(Arrays.asList(1,2, 4, 6));

        System.out.println("Before merging:");
        System.out.println("A: " + A);
        System.out.println("B: " + B);

        merge(A, B);

        System.out.println("After merging:");
        System.out.println("A: " + A);
    }
}
