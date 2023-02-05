package com.jacobcai.ccc;

public class Lc214 {
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        StringBuilder sb = new StringBuilder(s + '#' + rev);
        int[] pi = new int[sb.length()];
        for (int i = 0, j = 1; j < sb.length(); j++) {
            while (i > 0 && sb.charAt(i) != sb.charAt(j)) i = pi[i - 1];
            if (sb.charAt(i) == sb.charAt(j)) i++;
            pi[j] = i;
        }
        return rev.substring(0, rev.length() - pi[sb.length() - 1]) + s;
    }

    public static void main(String[] args) {
        Lc214 lc214 = new Lc214();
        String s = "abac"; // abac#caba
        String res = lc214.shortestPalindrome(s);
        System.out.println("res = " + res);
    }
}
