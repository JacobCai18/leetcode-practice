package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,
                      0,
                      nums.length - 1);
    }
    
    private TreeNode helper(int[] nums,
                            int le,
                            int ri) {
        if (le > ri) {
            return null;
        }
        int mid = (le + ri) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,
                           le,
                           mid - 1);
        root.right = helper(nums,
                            mid + 1,
                            ri);
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Lc108 lc108 = new Lc108();
        TreeNode res = lc108.sortedArrayToBST(nums);
        TreeNode.print(res);
    }
}
