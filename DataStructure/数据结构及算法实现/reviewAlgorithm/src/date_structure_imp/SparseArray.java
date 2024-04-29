package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.io.*;
import java.util.Arrays;

/**
 * 1. 稀疏数组的运用
 */
public class SparseArray {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //原数组的定义
        int[][] sparseArr = new int[11][11];
        sparseArr[3][5] = 1;
        sparseArr[7][4] = 3;
        sparseArr[4][3] = 6;

        int[][] result = tranSparse(sparseArr);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        //存入
        ObjectOutputStream op = new ObjectOutputStream(new FileOutputStream("sparseArr.dat"));
        op.writeObject(result);

        //读取
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("sparseArr.dat"));
        int[][] sparse = (int[][]) oi.readObject();

        int[][] ordinalArr = tranArr(sparse);
        for (int[] row : ordinalArr) {
            System.out.println(Arrays.toString(row));
        }

    }

    /**
     * 将一个数组转换成稀疏数组
     *
     * @param arr
     * @return
     */
    public static int[][] tranSparse(int[][] arr) {
        if (arr == null)
            return null;
        //1. 得到有效元素个数
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    num += 1;
                }
            }
        }
        //2. 创建稀疏数组
        int[][] sparseArr = new int[num + 1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = num;
        //3. 填充数据
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count += 1;
                }
            }
        }
        return sparseArr;
    }

    /**
     * 将一个稀疏数组转换成原数组
     *
     * @param arr
     * @return
     */
    public static int[][] tranArr(int[][] arr) {
        if (arr == null) {
            return null;
        }
        //1. 得到原数组
        int[][] sparse = new int[arr[0][0]][arr[0][1]];
        //2. 填充数据
        for (int i = 1; i < arr.length; i++) {
            sparse[arr[i][0]][arr[i][1]] = arr[i][2];
        }
        return sparse;
    }
}
