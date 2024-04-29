package algorithm_imp.sorting_imp;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author MrkWinter
 * @version 1.0
 * 此练习用于复习八大排序算法
 */
public class Practice {
    private static int[] arr = {1, 4, 2, 7, 9, 0, 3, 2};

    public static void main(String[] args) {
        Practice practice = new Practice();
//        practice.bubbleSort(arr);
//        practice.quickSort(arr, 0, arr.length - 1);
//        practice.insertSort(arr);
//        practice.shallSort(arr);
//        practice.selectSort(arr);
//        practice.bigHeapSort(arr);
//        practice.smallHeapSort(arr);
//        practice.mergeSort(arr);
//        practice.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ---------------- 交换排序 ----------------
     **/
    //1. 冒泡排序 o(n^2)
    public void bubbleSort(int[] arr) {
        boolean index = true;
        for (int i = 0; i < arr.length - 1; i++) {
            index = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    index = true;
                }
            }
            if (!index) break;
        }
    }

    //2. 快速排序 o(nlog(2)n)
    public void quickSort(int[] arr, int start, int end) {
        int leftIndex = start;
        int rightIndex = end;
        int midNum = arr[start];
        while (leftIndex < rightIndex) {
            while (arr[rightIndex] >= midNum && rightIndex > leftIndex) {
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];
            while (arr[leftIndex] <= midNum && leftIndex < rightIndex) {
                leftIndex++;
            }
            arr[rightIndex] = arr[leftIndex];
            arr[leftIndex] = midNum;
        }
        if (leftIndex - 1 > start) {
            quickSort(arr, start, leftIndex - 1);
        }
        if (leftIndex + 1 < end) {
            quickSort(arr, leftIndex + 1, end);
        }
    }

    /**
     * ---------------- 插入排序 ----------------
     **/

    //3. (直接)插入排序 o(n^2)
    public void insertSort(int[] arr) {
        int curValue = 0;
        int insert = 0;
        for (int i = 1; i < arr.length; i++) {
            curValue = arr[i];
            for (insert = i; insert >= 1 && arr[insert - 1] > curValue; insert--) {
                arr[insert] = arr[insert - 1];
            }
            if (insert != i) {
                arr[insert] = curValue;
            }
        }
    }

    //4. (插入法)希尔排序 o(nlog(2)n)
    public void shallSort(int[] arr) {
        int curNum = 0;
        int insert = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                curNum = arr[i];
                for (insert = i; insert >= gap && arr[insert - gap] > curNum; insert -= gap) {
                    arr[insert] = arr[insert - gap];
                }
                if (insert != i) {
                    arr[insert] = curNum;
                }
            }
        }
    }

    /**
     * ---------------- 选择排序 ----------------
     **/

    //5. (简单)选择排序 o(n^2)
    public void selectSort(int[] arr) {
        int minNum = 0;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minNum = arr[i];
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minNum) {
                    minNum = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = minNum;
            }
        }
    }

    //6. 堆排序 o(nlog(2)n)
    //6.1 大顶堆排序 升序
    public void bigHeapSort(int[] arr) {
        for (int i = arr.length / 2 + 1; i >= 0; i--) {
            bigAdjust(arr, i, arr.length - 1);
        }
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            bigAdjust(arr, 0, i - 1);
        }
    }

    //使用二叉树中的一趟插入排序
    private void bigAdjust(int[] arr, int startRoot, int end) {
        int adjustNum = arr[startRoot];
        int adjustIndex = startRoot;
        for (int i = startRoot * 2 + 1; i <= end; i = i * 2 + 1) {
            //右大于左
            if (i + 1 <= end && arr[i + 1] > arr[i]) {
                i = i + 1;
            }
            if (arr[i] > adjustNum) {
                arr[adjustIndex] = arr[i];
                adjustIndex = i;
            } else {
                break;
            }
        }
        if (adjustIndex != startRoot)
            arr[adjustIndex] = adjustNum;
    }

    //6.2 小顶堆排序 降序
    public void smallHeapSort(int[] arr) {
        for (int i = arr.length / 2 + 1; i >= 0; i--) {
            smallAdjust(arr, i, arr.length - 1);
        }
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            smallAdjust(arr, 0, i - 1);
        }
    }

    private void smallAdjust(int[] arr, int startRoot, int end) {
        int adjustNum = arr[startRoot];
        int adjustIndex = startRoot;
        for (int i = startRoot * 2 + 1; i <= end; i = i * 2 + 1) {
            if (i + 1 <= end && arr[i + 1] < arr[i]) {
                i = i + 1;
            }
            if (arr[i] < adjustNum) {
                arr[adjustIndex] = arr[i];
                adjustIndex = i;
            } else {
                break;
            }
        }
        if (adjustIndex != startRoot)
            arr[adjustIndex] = adjustNum;
    }

    /**
     * 7 o(nlog(2)n)
     * ---------------- 归并排序  ----------------
     **/
    public void mergeSort(int[] arr) {
        if (arr == null)
            return;
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            while (i <= mid && j <= right && arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }
            while (j <= right && i <= mid && arr[j] < arr[i]) {
                temp[t++] = arr[j++];
            }
        }
        if (i <= mid) {
            while (i <= mid) {
                temp[t++] = arr[i++];
            }
        }
        if (j <= right) {
            while (j <= right) {
                temp[t++] = arr[j++];
            }
        }
        for (int k = 0, l = left; k < t; k++, l++) {
            arr[l] = temp[k];
        }
    }

    /**
     * 8 o(n*k)
     * ---------------- 基数排序(桶排序)  ----------------
     **/

    public void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] number = new int[10];
        int max = arr[0];
        for (int value : arr) {
            max = Math.max(value, max);
        }
        int sortNum = Integer.toString(max).length();
        int value = 0;
        int bucketIndex = 0;
        int arrIndex = 0;
        for (int i = 0; i < sortNum; i++) {
            for (int j = 0; j < arr.length; j++) {
                value = arr[j];
                bucketIndex = value % (int) Math.pow(10, i+1);
                bucket[bucketIndex][number[bucketIndex]++] = value;
            }
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < number[j]; k++) {
                    arr[arrIndex++] = bucket[j][k];
                }
            }
            Arrays.fill(number, 0);
            arrIndex = 0;
        }
    }
}
