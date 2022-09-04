package com.jacobcai.c;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc32_1 {
    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // stack里放最后一个没有被匹配的')'的下标
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // 读到的是'('还是')'
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // pop栈顶的'('或最后一个没有被匹配的')'的下标
                stack.pop();
                // 栈是否为空
                if (stack.isEmpty()) {
                    // push最后一个没有被匹配的')'的下标
                    stack.push(i);
                } else {
                    res = Math.max(res,
                                   i - stack.peek());
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s = ")()())";
        Lc32_1 lc32_1 = new Lc32_1();
        int res = lc32_1.longestValidParentheses(s);
        System.out.println("res = " + res);
    }
}
