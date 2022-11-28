package com.jacobcai.c;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc78 {
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
        for (int i = 0; i <= nums.length; i++) {
            backtrack(i,
                      0);
        }
        return res;
    }
    
    /**
     * @param i     当前子集长度
     * @param index 当前使用的 nums 的下标
     */
    private void backtrack(int i,
                           int index) {
        if (deque.size() == i) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int j = index; j < nums.length; j++) {
            deque.addLast(nums[j]);
            backtrack(i,
                      j + 1);
            deque.removeLast();
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Lc78 lc78 = new Lc78();
        List<List<Integer>> res = lc78.subsets(nums);
        System.out.println("res = " + res);
    }
}
