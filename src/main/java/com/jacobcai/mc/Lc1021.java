package com.jacobcai.mc;

public class Lc1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') cnt--;
            if (cnt > 0) sb.append(c);
            if (c == '(') cnt++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc1021 lc1021 = new Lc1021();
        String s = "(()())(())(()(()))";
        String res = lc1021.removeOuterParentheses(s);
        System.out.println("res = " + res);
    }
}
