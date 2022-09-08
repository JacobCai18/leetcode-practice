package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc112 {
    public boolean hasPathSum(TreeNode root,
                              int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
    
    public static void main(String[] args) {
        TreeNode n1, n2, n3;
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1,
                          n2,
                          n3);
        int targetSum = 4;
        Lc112 lc112 = new Lc112();
        boolean res = lc112.hasPathSum(n1,
                                       targetSum);
        System.out.println("res = " + res);
    }
}
