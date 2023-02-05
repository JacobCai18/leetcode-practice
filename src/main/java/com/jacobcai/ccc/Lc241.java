package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.List;

public class Lc241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int n = expression.length();
        int start;
        for (start = 0; start < n; start++)
            if (!Character.isDigit(expression.charAt(start))) break;
        if (start == n) res.add(Integer.parseInt(expression));
        for (int i = start; i < n; i++) {
            if (Character.isDigit(expression.charAt(i))) continue;
            char op = expression.charAt(i);
            List<Integer> l1 = diffWaysToCompute(expression.substring(0, i));
            List<Integer> l2 = diffWaysToCompute(expression.substring(i + 1, n));
            for (int x1 : l1) {
                for (int x2 : l2) {
                    if (op == '+') res.add(x1 + x2);
                    else if (op == '-') res.add(x1 - x2);
                    else if (op == '*') res.add(x1 * x2);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc241 lc241 = new Lc241();
        String expression = "2-1-1";
        List<Integer> res = lc241.diffWaysToCompute(expression);
        System.out.println("res = " + res);
    }
}
