package day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author MrkWinter
 * @version 1.0
 * 189. 轮转数组
 * 提示
 * 中等
 * 2K
 * 相关企业
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * 通过次数
 * 746.5K
 * 提交次数
 * 1.7M
 * 通过率
 * 44.4%
 */
public class Rotate {
    /*
    每次向右轮转1次 轮转n次
     */
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 13;
        rotate.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] copyArr = Arrays.copyOf(nums, length);
        k = k % length;
        int j = 0;
        for (int i = length - k; i <= length - 1; i++) {
            nums[j] = copyArr[i];
            j += 1;
        }
        for (int i = 0; i < length - k; i++) {
            nums[j] = copyArr[i];
            j += 1;
        }
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < k; i++) {
            int first = nums[length - 1];
            for (int j = length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = first;
        }
    }
}
