package com.jacobcai.c;

public class Lc76 {
    public String minWindow(String s,
                            String t) {
        // ASCII表总长128
        // 目标 String 中各个 char 的出现次数
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // 当前 substring 中各个 char 的出现次数
        int[] curr = new int[128];
        // window: [left, right）
        int left = 0;
        int right = 0;
        // minLength 初始值为一定不可达到的长度
        int minLength = s.length() + 1;
        // 当前 substring 中目标 String 出现的 char 的出现次数
        int count = 0;
        // minLength 的 substring 在 s 中的起始位置
        int start = 0;
        
        while (right < s.length()) {
            char charAtRight = s.charAt(right);
            // right++ 至出现目标 char 的位置
            if (need[charAtRight] == 0) {
                right++;
                continue;
            }
            // 对应 char 未达到次数
            if (curr[charAtRight] < need[charAtRight]) {
                count++;
            }
            curr[charAtRight]++;
            right++;
            // 涵盖 t 所有字符：包含 t 中所有 char，对应的出现次数 >= t 中 char 出现次数
            // 以 t.length() 作为判断
            while (count == t.length()) {
                // 不用 Math.min 是为了记录出现 minLength 时的 start
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }
                char charAtLeft = s.charAt(left);
                // left++ 至出现目标 char 的位置
                if (need[charAtLeft] == 0) {
                    left++;
                    continue;
                }
                // 如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                // 就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次 count - 1
                if (curr[charAtLeft] == need[charAtLeft]) {
                    count--;
                }
                curr[charAtLeft]--;
                left++;
            }
        }
        // 如果 minLength 还为初始值，说明没有符合条件的 substring
        if (minLength == s.length() + 1) {
            return "";
        }
        // 要先设计return
        return s.substring(start,
                           start + minLength);
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
