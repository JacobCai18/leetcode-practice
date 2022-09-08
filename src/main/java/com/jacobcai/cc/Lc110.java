package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left)
                && isBalanced(root.right)
                && Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left),
                        height(root.right)) + 1;
    }
    
    public static void main(String[] args) {
        TreeNode n3, n9, n20, n15, n7;
        n15 = new TreeNode(15);
        n7 = new TreeNode(7);
        n20 = new TreeNode(20,
                           n15,
                           n7);
        n9 = new TreeNode(9);
        n3 = new TreeNode(3,
                          n9,
                          n20);
        Lc110 lc110 = new Lc110();
        boolean res = lc110.isBalanced(n3);
        System.out.println("res = " + res);
    }
}
