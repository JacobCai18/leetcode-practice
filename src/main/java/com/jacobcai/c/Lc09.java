package com.jacobcai.c;

public class Lc09 {
    public boolean isPalindrome(int x) {
        // 不是回文数的情况：负数 || 非 0 最后一位为0
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        // 用y记录翻转后的x的后半部分
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        // 若x偶，需x == y; 若x奇，需x == y / 10
        return x == y || x == y / 10;
    }
    
    public static void main(String[] args) {
        int x = 1234321;
        Lc09 lc09 = new Lc09();
        boolean res = lc09.isPalindrome(x);
        System.out.println("res = " + res);
    }
}
