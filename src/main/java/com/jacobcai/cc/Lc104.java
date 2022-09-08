package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),
                        maxDepth(root.right)) + 1;
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
        Lc104 lc104 = new Lc104();
        int res = lc104.maxDepth(n3);
        System.out.println("res = " + res);
    }
}
