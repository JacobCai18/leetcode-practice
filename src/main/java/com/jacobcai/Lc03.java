package com.jacobcai;

public class Lc03 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen, le, ri;
        maxLen = 0;
        le = ri = 0;
        // ASCII有128个字符
        // 记录right所指的字符所对应的备选left
        int[] map = new int[128];
        // right走到头就结束
        for (; ri < s.length(); ri++) {
            char c;
            // left不回头
            le = Math.max(le,
                            map[c = s.charAt(ri)]);
            // 下次遇到相同c的备选left
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
