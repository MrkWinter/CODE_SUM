package day5;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 2731. 移动机器人
 * 提示
 * 中等
 * 91
 * 相关企业
 * <p>
 * 有一些机器人分布在一条无限长的数轴上，他们初始坐标用一个下标从 0 开始的整数数组 nums 表示。当你给机器人下达命令时，它们以每秒钟一单位的速度开始移动。
 * <p>
 * 给你一个字符串 s ，每个字符按顺序分别表示每个机器人移动的方向。'L' 表示机器人往左或者数轴的负方向移动，'R' 表示机器人往右或者数轴的正方向移动。
 * <p>
 * 当两个机器人相撞时，它们开始沿着原本相反的方向移动。
 * <p>
 * 请你返回指令重复执行 d 秒后，所有机器人之间两两距离之和。由于答案可能很大，请你将答案对 109 + 7 取余后返回。
 * <p>
 * 注意：
 * <p>
 * 对于坐标在 i 和 j 的两个机器人，(i,j) 和 (j,i) 视为相同的坐标对。也就是说，机器人视为无差别的。
 * 当机器人相撞时，它们 立即改变 它们的前进方向，这个过程不消耗任何时间。
 * <p>
 * 当两个机器人在同一时刻占据相同的位置时，就会相撞。
 * <p>
 * 例如，如果一个机器人位于位置 0 并往右移动，另一个机器人位于位置 2 并往左移动，下一秒，它们都将占据位置 1，并改变方向。再下一秒钟后，第一个机器人位于位置 0 并往左移动，而另一个机器人位于位置 2 并往右移动。
 * <p>
 * 例如，如果一个机器人位于位置 0 并往右移动，另一个机器人位于位置 1 并往左移动，下一秒，第一个机器人位于位置 0 并往左行驶，而另一个机器人位于位置 1 并往右移动。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,0,2], s = "RLL", d = 3
 * 输出：8
 * 解释：
 * 1 秒后，机器人的位置为 [-1,-1,1] 。现在下标为 0 的机器人开始往左移动，下标为 1 的机器人开始往右移动。
 * 2 秒后，机器人的位置为 [-2,0,0] 。现在下标为 1 的机器人开始往左移动，下标为 2 的机器人开始往右移动。
 * 3 秒后，机器人的位置为 [-3,-1,1] 。
 * 下标为 0 和 1 的机器人之间距离为 abs(-3 - (-1)) = 2 。
 * 下标为 0 和 2 的机器人之间的距离为 abs(-3 - 1) = 4 。
 * 下标为 1 和 2 的机器人之间的距离为 abs(-1 - 1) = 2 。
 * 所有机器人对之间的总距离为 2 + 4 + 2 = 8 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,0], s = "RL", d = 2
 * 输出：5
 * 解释：
 * 1 秒后，机器人的位置为 [2,-1] 。
 * 2 秒后，机器人的位置为 [3,-2] 。
 * 两个机器人的距离为 abs(-2 - 3) = 5 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -2 * 109 <= nums[i] <= 2 * 109
 * 0 <= d <= 109
 * nums.length == s.length
 * s 只包含 'L' 和 'R' 。
 * nums[i] 互不相同。
 */
/*
字符数据记录机器人移动的方向
每次每个机器人只移动一格
如果机器人相撞 两个相邻机器人坐标对应的字符方向数组该方向
循环进行d次
 */

public class SumDistance {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 2};
        String s = "RLL";
        int d = 3;
        SumDistance sumD = new SumDistance();
        int i = sumD.sumDistance(nums, s, d);
        System.out.println(i);
    }

    public int sumDistance(int[] nums, String s, int d) {
        char[] direction = s.toCharArray();
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < nums.length; j++) {
                switch (direction[j]) {
                    case 'L':
                        nums[j] = nums[j] - 1;
                        if (j - 1 >= 0 && nums[j - 1] == nums[j]) {
                            //调整方向
                            direction[j - 1] = direction[j - 1] == 'R' ? 'L' : 'R';
                            direction[j] = direction[j] == 'R' ? 'L' : 'R';
                        }
                        break;
                    case 'R':
                        nums[j] = nums[j] + 1;
                        if (j + 1 < direction.length && nums[j + 1] == nums[j]) {
                            direction[j + 1] = direction[j + 1] == 'R' ? 'L' : 'R';
                            direction[j] = direction[j] == 'R' ? 'L' : 'R';
                        }
                        break;
                }
            }
        }
        //求距离和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += Math.abs(nums[i] - nums[j]);
            }
        }
        return sum;
    }

    static final int MOD = 1000000007;

    public int sumDistance2(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long) nums[i] - d;
            } else {
                pos[i] = (long) nums[i] + d;
            }
        }
        Arrays.sort(pos);
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += 1L * (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD;
            res %= MOD;
        }
        return (int) res;
    }
}
