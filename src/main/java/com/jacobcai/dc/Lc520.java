package com.jacobcai.dc;

public class Lc520 {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1)))
            return false;
        for (int i = 2; i < n; i++)
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1)))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Lc520 lc520 = new Lc520();
        String word = "USA";
        boolean res = lc520.detectCapitalUse(word);
        System.out.println("res = " + res);
    }
}
