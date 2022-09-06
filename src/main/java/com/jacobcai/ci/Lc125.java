package com.jacobcai.ci;

public class Lc125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuilder sbRev = new StringBuilder(sb).reverse();
        return sb.toString().equals(sbRev.toString());
    }
    
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Lc125 lc125 = new Lc125();
        boolean res = lc125.isPalindrome(s);
        System.out.println("res = " + res);
    }
}
