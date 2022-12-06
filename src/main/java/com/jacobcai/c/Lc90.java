package com.jacobcai.c;

import java.util.*;

public class Lc90 {
    private List<List<Integer>> res;
    private Deque<Integer> deque;
    private int[] nums;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(0);
        return res;
    }
    
    private void backtrack(int index) {
        res.add(new ArrayList<>(deque));
        for (int i = index; i < nums.length; i++) {
            // 同层已使用过的数不再使用
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            deque.addLast(nums[i]);
            backtrack(i + 1);
            deque.removeLast();
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        Lc90 lc90 = new Lc90();
        List<List<Integer>> res = lc90.subsetsWithDup(nums);
        System.out.println("res = " + res);
    }
}
