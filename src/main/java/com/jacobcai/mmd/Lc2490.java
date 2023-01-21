package com.jacobcai.mmd;

public class Lc2490 {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(n - 1))
            return false;
        for (int i = 0; i < n; i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc2490 lc2490 = new Lc2490();
        String sentence = "leetcode exercises sound delightful";
        boolean res = lc2490.isCircularSentence(sentence);
        System.out.println("res = " + res);
    }
}
