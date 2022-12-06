package com.jacobcai.dc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[len];
        for (int i = 0; i < 2 * len - 1; i++) {
            // 循环数组，取模
            int num = nums[i % len];
            // 单调栈，栈顶到栈底递增
            while (!deque.isEmpty() && num > nums[deque.getFirst()]) {
                res[deque.removeFirst()] = num;
            }
            // 入栈过一次的下标不用再入栈
            if (i < len) {
                deque.addFirst(i);
            }
        }
        // 最大值不会有比它更大的值
        while (!deque.isEmpty()) {
            res[deque.removeFirst()] = -1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 4, 3};
        Lc503 lc503 = new Lc503();
        int[] res = lc503.nextGreaterElements(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
