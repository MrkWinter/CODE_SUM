package algorithm_imp.search_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

/**
 * 2. 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = binarySearch1(arr, 0, arr.length - 1, 10);
        System.out.println(i);
        int j = binarySearch2(arr, 0, arr.length - 1, 10);
        System.out.println(j);
    }

    /**
     * 递归 二分查找法
     */
    public static int binarySearch1(int[] arr, int left, int right, int value) {
        if (left >= right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return binarySearch1(arr, mid + 1, right, value);
        } else {
            return binarySearch1(arr, left, mid - 1, value);
        }
    }

    /**
     * 非递归二分查找法
     */
    public static int binarySearch2(int[] arr, int left, int right, int value) {
        int mid = 0;
        int leftIndex = left;
        int rightIndex = right;
        int result = -1;
        while (leftIndex <= rightIndex) {
            mid = (leftIndex + rightIndex) / 2;
            if (arr[mid] < value) {
                leftIndex = mid + 1;
            } else if (arr[mid] > value) {
                rightIndex = mid - 1;
            } else {
                result = mid;
                break;
            }
        }
        return result;
    }
}
