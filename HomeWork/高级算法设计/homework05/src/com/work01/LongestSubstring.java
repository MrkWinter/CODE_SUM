package com.work01;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String  str = "acdefdhefdaf";
        String s = new LongestSubstring().longestSubstring(str);
        System.out.println(s);
    }
    /**
     * 滑动窗口求 最长无重复子串
     * @param s
     * @return
     */
    public String longestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0, start = 0, end = 0;
        int maxStart = 0, maxEnd = 0;
        while (start < n && end < n) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                    maxStart = start;
                    maxEnd = end;
                }
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
