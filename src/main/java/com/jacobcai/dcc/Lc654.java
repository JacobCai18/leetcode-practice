package com.jacobcai.dcc;

import com.jacobcai.TreeNode;

public class Lc654 {
    private int[] nums;
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return helper(0,
                      nums.length - 1);
    }
    
    private TreeNode helper(int le,
                            int ri) {
        if (le > ri) {
            return null;
        }
        int max = le;
        for (int i = le + 1; i <= ri; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode head = new TreeNode(nums[max]);
        head.left = helper(le,
                           max - 1);
        head.right = helper(max + 1,
                            ri);
        return head;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Lc654 lc654 = new Lc654();
        TreeNode res = lc654.constructMaximumBinaryTree(nums);
        TreeNode.print(res);
    }
}
