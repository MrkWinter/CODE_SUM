package algorithm_imp.search_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 此练习用于复习常用的4种查找算法
 */
public class Practice {
    private static int[] arr = {1, 23, 34, 67, 78, 78, 209, 345, 567};

    public static void main(String[] args) {
        Practice practice = new Practice();
//        int i = practice.linearSearch(arr, 78);
//        System.out.println(i);
//        int i = practice.binarySearch1(arr, 78, 0, arr.length - 1);
//        System.out.println(i);
//        int i = practice.binarySearch2(arr, 78, 0, arr.length - 1);
//        System.out.println(i);
//        int i = practice.interpolationSearch(arr, 78);
//        System.out.println(i);
        int i = practice.fibonacciSearch(arr, 567);
        System.out.println(i);
    }

    //1. 顺序查找 (线性查找法)
    public int linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return i;
        }
        return -1;
    }

    //2. 二分查找法
    //递归
    public int binarySearch1(int[] arr, int num, int left, int right) {
        if (left >= right || left < 0 || right >= arr.length)
            return -1;
        int mid = (left + right) / 2;
        if (arr[mid] < num)
            return binarySearch1(arr, num, mid + 1, right);
        else if (arr[mid] > num)
            return binarySearch1(arr, num, left, mid - 1);
        else
            return mid;
    }

    //非递归
    public int binarySearch2(int[] arr, int num, int left, int right) {
        int start = left;
        int end = right;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] < num) {
                start = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //3. 插值查找(自适应查找)
    public int interpolationSearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            if (arr[right] != arr[left])
                mid = left - (left - right) * (num - arr[left]) / (arr[right] - arr[left]);
            else
                mid = (left + right) / 2;
            if (num < arr[mid]) {
                right = mid - 1;
            } else if (num > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //4. 斐波那契查找
    public int fibonacciSearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0;
        int mid = 0;
        int[] fibonacciArr = getFibonacciArr(20);
        while (fibonacciArr[k]<arr.length) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fibonacciArr[k]);
        for (int i = right+1; i <temp.length; i++) {
            temp[i] = arr[right];
        }
        while (left<=right) {
            mid = left+fibonacciArr[k-1]-1;
            if(temp[mid]>num) {
                right = mid-1;
                k--;
            } else if(temp[mid]<num) {
                left = mid +1;
                k-=2;
            }else {
                return Math.min(mid, arr.length-1);
            }
        }
        return -1;
    }

    public int[] getFibonacciArr(int n) {
        if (n < 3)
            return null;
        int[] ints = new int[n];
        ints[0] = ints[1] = 1;
        for (int i = 2; i < n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints;
    }
}
