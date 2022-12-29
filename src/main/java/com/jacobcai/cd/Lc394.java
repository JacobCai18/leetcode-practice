package com.jacobcai.cd;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        Deque<Integer> stackInt = new ArrayDeque<>();
        Deque<String> stackStr = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stackInt.addFirst(multi);
                stackStr.addFirst(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackInt.removeFirst();
                tmp.append(String.valueOf(sb)
                                 .repeat(curMulti));
                sb = new StringBuilder(stackStr.removeFirst() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "3[a2[c2[b]]]";
        Lc394 lc394 = new Lc394();
        String res = lc394.decodeString(s);
        System.out.println("res = " + res);
    }
}
