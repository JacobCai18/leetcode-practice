package com.jacobcai.c;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc78_2 {
    /**
     * nums 数组
     */
    int[] nums;
    /**
     * nums 数组所有可能的子集
     */
    List<List<Integer>> res;
    /**
     * 用于构建子集
     */
    Deque<Integer> deque;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        backtrack(0);
        return res;
    }
    
    /**
     * @param index 当前使用的 nums 的下标
     */
    private void backtrack(int index) {
        res.add(new ArrayList<>(deque));
        for (int i = index; i < nums.length; i++) {
            deque.addLast(nums[i]);
            backtrack(i + 1);
            deque.removeLast();
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Lc78_2 lc78_2 = new Lc78_2();
        List<List<Integer>> res = lc78_2.subsets(nums);
        System.out.println("res = " + res);
    }
}
