package com.jacobcai.c;

public class Lc76 {
    public String minWindow(String s,
                            String t) {
        int[] sWinFreq, tFreq;
        int le, ri, start, minLen, sWinCount;
        sWinFreq = new int[128];
        tFreq = new int[128];
        for (char c : t.toCharArray()) tFreq[c]++;
        le = ri = start = 0;
        minLen = s.length() + 1;
        // 当前 substring 中目标 String 出现的 char 的出现次数
        sWinCount = 0;
        while (ri < s.length()) {
            char charAtRi = s.charAt(ri);
            if (tFreq[charAtRi] == 0) {
                ri++;
                continue;
            }
            // 对应 char 未达到次数
            if (sWinFreq[charAtRi]++ < tFreq[charAtRi]) sWinCount++;
            ri++;
            // 窗口包含了所有 t 中字符
            while (sWinCount == t.length()) {
                // 不用 Math.min 是为了记录出现 minLen 时的 start
                if (ri - le < minLen) {
                    minLen = ri - le;
                    start = le;
                }
                char charAtLe = s.charAt(le);
                if (tFreq[charAtLe] == 0) {
                    le++;
                    continue;
                }
                // 如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                // 就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次 sWinCount - 1
                if (--sWinFreq[charAtLe] < tFreq[charAtLe]) sWinCount--;
                le++;
            }
        }
        // 如果 minLen 还为初始值，说明没有符合条件的 substring
        if (minLen == s.length() + 1) return "";
        // 要先设计return
        return s.substring(start, start + minLen);
    }
    
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Lc76 lc76 = new Lc76();
        String res = lc76.minWindow(s,
                                    t);
        System.out.println("res = " + res);
    }
}
