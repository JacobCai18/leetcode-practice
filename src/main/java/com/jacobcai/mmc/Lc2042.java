package com.jacobcai.mmc;

public class Lc2042 {
    public boolean areNumbersAscending(String s) {
        int len = s.length();
        int i = 0;
        int pre = -1;
        int cur = 0;
        while (i < len) {
            if (!Character.isDigit(s.charAt(i))) {
                i++;
                continue;
            }
            while (i < len && Character.isDigit(s.charAt(i))) {
                cur = 10 * cur + s.charAt(i) - '0';
                i++;
            }
            if (pre != -1 && pre >= cur) {
                return false;
            }
            pre = cur;
            cur = 0;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        Lc2042 lc2042 = new Lc2042();
        boolean res = lc2042.areNumbersAscending(s);
        System.out.println("res = " + res);
    }
}
