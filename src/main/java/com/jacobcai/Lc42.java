package com.jacobcai;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc42 {
    public int trap(int[] height) {
        int len, res;
        res = 0;
        if ((len = height.length) < 3) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (!stack.isEmpty() && height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else if (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cur = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                    res += (height[stack.peek()] - height[cur]) * (i - stack.peek() - 1);
                    cur = stack.pop();
                }
                if (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    res += (height[i] - height[cur]) * (i - stack.peek() - 1);
                }
                stack.push(i);
            }
            if (stack.isEmpty()) {
                stack.push(i);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 3, 2, 1, 1, 0, 2, 3, 2, 1};
        Lc42 lc42 = new Lc42();
        int res = lc42.trap(height);
        System.out.println("res = " + res);
    }
}
