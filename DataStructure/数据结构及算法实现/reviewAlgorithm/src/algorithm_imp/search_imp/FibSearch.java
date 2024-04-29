package algorithm_imp.search_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class FibSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = fibSearch1(arr, 9);
        System.out.println(i);
    }

    public static int fibSearch1(int[] arr, int value) {
        int[] fib = getFib(20);
        int f = 1;
        //数组的数的个数要刚好等于斐波那契数 这样才满足前f[k-1] - 1个数为前半 mid 为第 f[k-1] - 1 个数
        //后半部分有f[k-2]-1个数
        while (fib[f] < arr.length) {
            f += 1;
        }
        int right = arr.length - 1;
        int[] tArr = Arrays.copyOf(arr, fib[f]);
        for (int i = right + 1; i < tArr.length; i++) {
            tArr[i] = arr[right];
        }

        int mid = 0;
        int left = 0;
        while (left <= right) { //这里循环限制 斐波那契数到达第一个 第二个数后 查找不到 跳出循环
            mid = left + fib[f - 1] - 1;
            if (tArr[mid] < value) {
                left = mid + 1;
                f -= 2;
            } else if (tArr[mid] > value) {
                right = mid - 1;
                f -= 1;
            } else {
                return mid > arr.length - 1 ? arr.length - 1 : mid;
            }
        }
        return -1;
    }

    public static int[] getFib(int n) {
        int[] fibArr = new int[n];
        fibArr[0] = 1;
        if (n == 1)
            return fibArr;
        fibArr[1] = 1;
        if (n == 2)
            return fibArr;
        for (int i = 2; i < n; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
        return fibArr;
    }
    //查找算法 要考虑等于的条件
}
