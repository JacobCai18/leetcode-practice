package com.jacobcai.ccc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc227 {
    public int calculate(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        char preSign = '+';
        int num = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i)))
                num = num * 10 + s.charAt(i) - '0';
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+' -> stk.push(num);
                    case '-' -> stk.push(-num);
                    case '*' -> stk.push(stk.pop() * num);
                    default -> stk.push(stk.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stk.isEmpty()) res += stk.pop();
        return res;
    }

    public static void main(String[] args) {
        Lc227 lc227 = new Lc227();
        String s = "3+2*2";
        int res = lc227.calculate(s);
        System.out.println("res = " + res);
    }
}
