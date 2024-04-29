package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */

/**
 * 8.基数排序
  */
public class BlanketSort {
    public static void main(String[] args) {
        int[] arr = {21,44,18,35,82,3,73,94};
        blanketSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序的基本思想是按位划分排序
     * 用基于原数组10倍的内存创建10个桶
     * 先按个位排序 依次放入桶中 然后再按桶顺序取出 数组中的数字就按个位排序了
     * 然后再次按十位进行排序 放入桶中再拿出
     * 直到最大位排序后 整个数组就是有序的
     */
    public static void blanketSorting(int[] arr) {
        //先得出最大位数 排序次数
        int max = Arrays.stream(arr).max().getAsInt();
        int sortTimes = 0;
        while (max!=0) {
            max/=10;
            sortTimes+=1;
        }
        int len = arr.length;
        int[][] blanket = new int[10][len];
        int[] bNum = new int[10];
        int cNum = 1;
        for (int i = 0; i < sortTimes; i++) {
            for (int e : arr) {
              int index =  (e/cNum) % 10;
              blanket[index][bNum[index]++] = e;
            }
            //从桶中拿数据
            int h = 0;
            for (int j = 0; j < blanket.length; j++) {
                for (int k = 0; k < bNum[j]; k++) {

                    arr[h++] = blanket[j][k];
                }
            }
            //清除桶数据
            Arrays.fill(bNum,0);
            cNum *=10;
        }
    }
}
