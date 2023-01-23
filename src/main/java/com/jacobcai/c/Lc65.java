package com.jacobcai.c;

public class Lc65 {
    private boolean check(char[] cs, int le, int ri, boolean mustInt) { // [le, ri)
        if (le == ri) return false;
        if (cs[le] == '+' || cs[le] == '-') le++;
        boolean hasDot = false, hasNum = false;
        for (int i = le; i < ri; i++) {
            if (cs[i] == '.') {
                if (mustInt || hasDot) return false;
                hasDot = true;
            } else if (cs[i] >= '0' && cs[i] <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }

    public boolean isNumber(String s) {
        int n = s.length(), eIdx = -1;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'e' || cs[i] == 'E') {
                if (eIdx == -1) eIdx = i; // 只能有一个 e / E
                else return false;
            }
        }
        boolean ans = true;
        if (eIdx == -1) {
            ans &= check(cs, 0, n, false);
        } else { // 有 e / E 时按其划分
            ans &= check(cs, 0, eIdx, false);
            ans &= check(cs, eIdx + 1, n, true);
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc65 lc65 = new Lc65();
        String s = "-2.32e3";
        boolean res = lc65.isNumber(s);
        System.out.println("res = " + res);
    }
}
