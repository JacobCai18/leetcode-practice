package com.jacobcai.c;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc71 {
    public String simplifyPath(String path) {
        // split
        String[] names;
        // 用栈整理
        // 四种情况 "..", ".", "", "anything"
        Deque<String> stack;
        // 输出整理后的结果
        StringBuilder res;
        names = path.split("/");
        stack = new ArrayDeque<>();
        for (String name : names) {
            if (name.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (name.length() > 0 && !name.equals(".")) {
                stack.addLast(name);
            }
        }
        res = new StringBuilder();
        if (stack.isEmpty()) {
            res.append("/");
        } else {
            while (!stack.isEmpty()) {
                res.append("/");
                res.append(stack.removeFirst());
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        String path = "/a/./b//../../c/";
        Lc71 lc71 = new Lc71();
        String res = lc71.simplifyPath(path);
        System.out.println("res = " + res);
    }
}
