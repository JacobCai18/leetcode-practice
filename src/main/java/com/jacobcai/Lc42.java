package com.jacobcai;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc42 {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int ri = 0; ri < height.length; ri++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[ri]) {
                // res += height * length
                // height = ceiling - floor
                // ceiling = Math.min(height[ri], height[le])
                // floor = height[floorIndex]
                // length = ri - le - 1
                int floorIndex = stack.pop();
                // 需要有左边的柱子才能接水
                if (stack.isEmpty()) {
                    break;
                }
                int le = stack.peek();
                res += (Math.min(height[ri],
                                 height[le]) - height[floorIndex]) * (ri - le - 1);
            }
            // 栈空||栈顶对应高度>=当前高度||栈顶对应高度<当前高度
            stack.push(ri);
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
