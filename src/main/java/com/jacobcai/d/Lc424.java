package com.jacobcai.d;

public class Lc424 {
    public int characterReplacement(String s,
                                    int k) {
        // 包含相同字母的最长子字符串的长度
        int maxLen = 0;
        // [le, ri)
        int le = 0;
        int ri = 0;
        // 记录当前窗口各个 char 的数量
        int[] curr = new int[26];
        // 当前窗口出现个数最多的 char 的数量
        int maxCount = 0;
        while (ri < s.length()) {
            // 将新读到的 ri 上的 char 计入 curr 对应位置
            curr[s.charAt(ri) - 'A']++;
            // 记录当前窗口出现个数最多的 char 的数量
            maxCount = Math.max(maxCount,
                                curr[s.charAt(ri) - 'A']);
            ri++;
            // 窗口左边移动的情况：用 k 替换非当前窗口出现个数最多的 char 后的子字符串长度 < 当前窗口长度
            // 当前窗口长度：ri - le
            if (maxCount + k < ri - le) {
                // 将 le 上的 char 在 curr 上对应位置减去
                curr[s.charAt(le) - 'A']--;
                le++;
            }
            // 记录 maxLen
            maxLen = Math.max(maxLen,
                              ri - le);
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        String s = "AABCACDAAB";
        int k = 2;
        Lc424 lc424 = new Lc424();
        int res = lc424.characterReplacement(s,
                                             k);
        System.out.println("res = " + res);
    }
}
