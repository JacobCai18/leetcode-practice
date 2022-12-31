package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc124 {
    int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        heightSum(root);
        return max;
    }
    
    private int heightSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int le = Math.max(heightSum(root.left),
                          0);
        int ri = Math.max(heightSum(root.right),
                          0);
        max = Math.max(max,
                       le + root.val + ri);
        return root.val + Math.max(le,
                                   ri);
    }
    
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n3 = new TreeNode(20,
                                   n4,
                                   n5);
        TreeNode n2 = new TreeNode(9);
        TreeNode n1 = new TreeNode(10,
                                   n2,
                                   n3);
        Lc124 lc124 = new Lc124();
        int res = lc124.maxPathSum(n1);
        System.out.println("res = " + res);
    }
}
