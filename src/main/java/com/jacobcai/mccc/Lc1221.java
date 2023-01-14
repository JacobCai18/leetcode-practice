package com.jacobcai.mccc;

public class Lc1221 {
    public int balancedStringSplit(String s) {
        int cnt = 0, diff = 0;
        for (char c : s.toCharArray()) {
            diff += c == 'L' ? 1 : -1;
            if (diff == 0) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lc1221 lc1221 = new Lc1221();
        String s = "LLRRLRLLRLLRRR";
        int res = lc1221.balancedStringSplit(s);
        System.out.println("res = " + res);
    }
}
