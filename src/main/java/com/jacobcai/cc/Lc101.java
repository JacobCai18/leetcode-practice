package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,
                   root.right);
    }
    
    private boolean dfs(TreeNode left,
                        TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left,
                   right.right) && dfs(left.right,
                                       right.left);
    }
    
    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5, n6, n7;
        n4 = new TreeNode(3);
        n5 = new TreeNode(4);
        n6 = new TreeNode(4);
        n7 = new TreeNode(3);
        n2 = new TreeNode(2,
                          n4,
                          n5);
        n3 = new TreeNode(2,
                          n6,
                          n7);
        n1 = new TreeNode(1,
                          n2,
                          n3);
        Lc101 lc101 = new Lc101();
        boolean res = lc101.isSymmetric(n1);
        System.out.println("res = " + res);
    }
}
