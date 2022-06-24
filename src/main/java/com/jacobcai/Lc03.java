package com.jacobcai;

public class Lc03 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        // ASCII有128个字符
        int[] map = new int[128];
        // right走到头就结束
        int len = s.length();
        for (int right = 0; right < len; right++) {
            // map中有重复的right所指的字符，定位left只增不减
            char c = s.charAt(right);
            left = Math.max(left, map[c]);
            // 若有重复的key，会覆盖val
            map[c] = right + 1;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Lc03 lc03 = new Lc03();
        int res = lc03.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
