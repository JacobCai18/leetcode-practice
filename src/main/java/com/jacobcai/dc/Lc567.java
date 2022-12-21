package com.jacobcai.dc;

public class Lc567 {
    public boolean checkInclusion(String s1,
                                  String s2) {
        char[] pattern, text;
        int pLen, tLen, pCount, winCount, le, ri;
        int[] pFreq, winFreq;
        pattern = s1.toCharArray();
        text = s2.toCharArray();
        pLen = pattern.length;
        tLen = text.length;
        pCount = winCount = 0;
        le = ri = 0;
        pFreq = new int[26];
        winFreq = new int[26];
        for (char c : pattern) pFreq[c - 'a']++;
        for (int freq : pFreq) {
            if (freq > 0) pCount++;
        }
        while (ri < tLen) {
            int riIndex = text[ri++] - 'a';
            if (pFreq[riIndex] > 0 && ++winFreq[riIndex] == pFreq[riIndex]) winCount++;
            // 当 text 窗口中出现的字符中包含全部 pattern 数组中出现的字符，并且对应字符的频数相同时，移动左指针
            while (winCount == pCount) {
                if (ri - le == pLen) return true;
                int leIndex = text[le++] - 'a';
                if (pFreq[leIndex] > 0 && --winFreq[leIndex] < pFreq[leIndex]) winCount--;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "dbac";
        Lc567 lc567 = new Lc567();
        boolean res = lc567.checkInclusion(s1,
                                           s2);
        System.out.println("res = " + res);
    }
}
