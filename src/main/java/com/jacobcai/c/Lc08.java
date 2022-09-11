package com.jacobcai.c;

import java.util.HashMap;
import java.util.Map;

public class Lc08 {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int len = str.length();
        for (int i = 0; i < len; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
    
    static class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private final Map<String, String[]> table = new HashMap<>() {{
            put("start",
                new String[]{"start", "signed", "in_number", "end"});
            put("signed",
                new String[]{"end", "end", "in_number", "end"});
            put("in_number",
                new String[]{"end", "end", "in_number", "end"});
            put("end",
                new String[]{"end", "end", "end", "end"});
        }};
        
        public void get(char c) {
            state = table.get(state)[getCol(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ?
                      Math.min(ans,
                               Integer.MAX_VALUE) :
                      Math.min(ans,
                               -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ?
                       1 :
                       -1;
            }
        }
        
        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }
    
    public static void main(String[] args) {
        String s = "  -42 ";
        Lc08 lc08 = new Lc08();
        int res = lc08.myAtoi(s);
        System.out.println("res = " + res);
    }
}
