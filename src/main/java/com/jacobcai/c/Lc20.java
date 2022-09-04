package com.jacobcai.c;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Lc20 {
    public boolean isValid(String s) {
        int len = s.length();
        // len为奇，return false
        if (len % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')',
                '(');
        map.put('}',
                '{');
        map.put(']',
                '[');
        // stack
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 右括号
            if (map.containsKey(c)) {
                // 栈空 || 栈顶与当前右括号对应的左括号不匹配
                if (deque.isEmpty() || deque.peekFirst() != map.get(c)) {
                    return false;
                }
                deque.removeFirst();
            } else { // 左括号
                deque.addFirst(c);
            }
        }
        return deque.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = "()[]{}";
        Lc20 lc20 = new Lc20();
        boolean res = lc20.isValid(s);
        System.out.println("res = " + res);
    }
}
