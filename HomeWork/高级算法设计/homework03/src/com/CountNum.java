package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class CountNum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7, 7};
        HashMap<Integer, Integer> hm = countNum(nums);
        Set<Map.Entry<Integer, Integer>> entries = hm.entrySet();
        for (Map.Entry<Integer, Integer> x : entries) {
            System.out.println(x.getKey() + "出现:" + x.getValue() + "次");
        }
    }
// 哈希表
    public static HashMap<Integer, Integer> countNum(int[] nums) {
        HashMap<Integer, Integer> ret = new HashMap<>();
        for (int x : nums) {
            ret.put(x, ret.getOrDefault(x, 0) + 1);
        }
        return ret;
    }
}
