/**
 * @author MrkWinter
 * @version 1.0
 */
public class Matrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] mat1 = {{1, 2, 4}, {3, 4, 8}, {1, 3, 6}};
        int[][] mat2 = {{2, 3, 2}, {5, 6, 5}, {4, 4, 1}};
//        matrix.matrixAdd(mat1, mat2);
//        matrix.matrixMul(mat1, mat2);
//        matrix.matrixTran(mat1);
//        matrix.matrixExchangeRow(mat1, mat2, 0, 0);
//        matrix.matrixExchangeCol(mat1, mat2, 1, 2);
        matrix.matrixSumByDia(mat1);
    }

    //矩阵相加
    public int[][] matrixAdd(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat2 == null)
            return null;
        int row = mat1.length;
        int col = mat1[0].length;
        if (row != mat2.length || col != mat2[0].length)
            return null;
        int[][] ret = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return ret;
    }

    //矩阵相乘
    public int[][] matrixMul(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat2 == null)
            return null;
        int row = mat1.length;
        int col = mat1[0].length;
        if (row != mat2[0].length || col != mat2.length)
            return null;
        int[][] ret = new int[row][row];
        for (int i = 0; i < row; i++) {
            //行
            for (int j = 0; j < row; j++) {
                //列
                int sum = 0;
                for (int k = 0; k < col; k++) {
                    sum += mat1[i][k] * mat2[k][j];
                }
                ret[i][j] = sum;
            }
        }
        return ret;
    }

    //矩阵转置
    public int[][] matrixTran(int[][] mat) {
        if (mat == null)
            return null;
        int row = mat.length;
        int col = mat[0].length;
        int[][] ret = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret[j][i] = mat[i][j];
            }
        }
        return ret;
    }

    //矩阵交换行
    public boolean matrixExchangeRow(int[][] mat1, int[][] mat2, int i, int j) {
        if (mat1 == null || mat2 == null)
            return false;
        int row1 = mat1.length;
        int row2 = mat2.length;
        if (row1 < i || row2 < j || i < 0 || j < 0)
            return false;
        if (mat1[0].length != mat2[0].length)
            return false;
        for (int k = 0; k < mat1[0].length; k++) {
            mat1[i][k] = mat1[i][k] ^ mat2[j][k];
            mat2[j][k] = mat1[i][k] ^ mat2[j][k];
            mat1[i][k] = mat1[i][k] ^ mat2[j][k];
        }
        return true;
    }

    //矩阵交换列
    public boolean matrixExchangeCol(int[][] mat1, int[][] mat2, int i, int j) {
        if (mat1 == null || mat2 == null)
            return false;
        int col1 = mat1[0].length;
        int col2 = mat2[0].length;
        if (col1 < i || col2 < j || i < 0 || j < 0)
            return false;
        if (mat1.length != mat2.length)
            return false;
        for (int k = 0; k < mat1.length; k++) {
            mat1[k][i] = mat1[k][i] ^ mat2[k][j];
            mat2[k][j] = mat1[k][i] ^ mat2[k][j];
            mat1[k][i] = mat1[k][i] ^ mat2[k][j];
        }
        return true;
    }

    //矩阵对角线求和
    int matrixSumByDia(int[][] mat) {
        if (mat == null)
            throw new RuntimeException("mat is null");
        if (mat.length != mat[0].length)
            throw new RuntimeException("Matrix does not meet specifications");
        int ret = 0;
        for (int i = 0, j = mat[0].length - 1; i < mat.length; i++, j--) {
            if (i != j)
                ret += mat[i][i] + mat[i][j];
            else
                ret += mat[i][i];
        }
        return ret;
    }
}
