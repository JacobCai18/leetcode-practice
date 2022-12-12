package com.jacobcai.mdccc;

public class Lc1781 {
    public int beautySum(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < len; j++) {
                int curFreq = ++cnt[s.charAt(j) - 'a'];
                maxFreq = Math.max(maxFreq, curFreq);
                int minFreq = len;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Lc1781 lc1781 = new Lc1781();
        int res = lc1781.beautySum("aabcb");
        System.out.println("res = " + res);
    }
}
