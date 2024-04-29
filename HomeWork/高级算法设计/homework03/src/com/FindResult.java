package com;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class FindResult {
    public static void main(String[] args) {
        findResult(4, 1);
    }

    public static void findResult(int arrLen, int range) {
        // arrLen是序列长度 range是序列值的范围 从0开始
        findResult(new int[arrLen], 0, range);
    }

    //递归
    private static void findResult(int[] post, int len, int range) {
        if (len == post.length) {
            //如果递归设置数到数组的最后一位 打印数组 得到一种解
            System.out.println(Arrays.toString(post));
            return;
        }
        for (int i = 0; i <= range; i++) {
            post[len] = i;
            //赋给当前位置上一种可能的数值 然后递归到下一位
            findResult(post, len + 1, range);
        }
    }
}

