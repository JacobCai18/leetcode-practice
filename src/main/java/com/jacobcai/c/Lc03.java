package com.jacobcai.c;

public class Lc03 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen, le;
        maxLen = 0;
        le = 0;
        // ASCII 有 128 个字符
        // <字符, 出现时的下标 + 1>
        int[] map = new int[128];
        // ri 走到头就结束
        for (int ri = 0; ri < s.length(); ri++) {
            char c;
            // le 不回头
            le = Math.max(le,
                          map[c = s.charAt(ri)]);
            // 下次遇到相同 c 的备选 le
            map[c] = ri + 1;
            maxLen = Math.max(maxLen,
                              ri - le + 1);
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
