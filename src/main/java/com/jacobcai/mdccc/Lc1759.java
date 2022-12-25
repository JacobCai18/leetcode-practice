package com.jacobcai.mdccc;

public class Lc1759 {
    private static final int MOD = (int) (1e9 + 7);
    
    public int countHomogenous(String s) {
        int i = 0;
        long cnt = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == cur) {
                j++;
            }
            long k = j - i;
            cnt += (k * k + k) / 2;
            i = j;
        }
        return (int) (cnt % MOD);
    }
    
    public static void main(String[] args) {
        String s = "abbcccaaaa";
        Lc1759 lc1759 = new Lc1759();
        int res = lc1759.countHomogenous(s);
        System.out.println("res = " + res);
    }
}
