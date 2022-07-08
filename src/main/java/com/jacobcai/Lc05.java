package com.jacobcai;

public class Lc05 {
    public String longestPalindrome(String s) {
        int head = 0;
        int tail = 0;
        int len = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = 0;
            int len2 = 0;
            // 以一个char为中心
            len1 = expandFromMid(i, i, s);
            // 以两个相同的char为中心
            len2 = expandFromMid(i, i + 1, s);
            if (len < Math.max(len1, len2)) {
                len = Math.max(len1, len2);
                // 记录此时的头尾，便于return子串
                tail = i + len / 2;
                head = tail - len + 1;
            }
        }
        // [head, tail + 1)
        return s.substring(head, tail + 1);
    }

    private int expandFromMid(int head, int tail, String s) {
        int len = 1;
        while (head > -1 && tail < s.length() && s.charAt(head) == s.charAt(tail)) {
            len = tail - head + 1;
            head--;
            tail++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "babad";
        Lc05 lc05 = new Lc05();
        String res = lc05.longestPalindrome(s);
        System.out.println("res = " + res);
    }
}
