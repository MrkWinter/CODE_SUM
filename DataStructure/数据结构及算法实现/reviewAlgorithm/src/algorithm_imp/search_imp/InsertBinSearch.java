package algorithm_imp.search_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

/**
 * 3. 插值查找
 */

/**
 * 插值查找就是在二分查找的基础上进行的改进 加入寻找值的权重 尽可能的快速找到该数的位置
 */
public class InsertBinSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = InsertBinarySearch1(arr, 0, arr.length - 1, 955);
        System.out.println(i);

    }

    private static int InsertBinarySearch1(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
            if (mid >= right || mid < left)
                return -1;
            //插值查找要规定返回 中值可能会不合理
            if (arr[mid] < value) {
                left = mid + 1;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
