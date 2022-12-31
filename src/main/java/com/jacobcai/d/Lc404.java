package com.jacobcai.d;

import com.jacobcai.TreeNode;

public class Lc404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right)
                + (root.left != null && root.left.left == null && root.left.right == null ?
                                                                           root.left.val :
                                                                           0);
    }
    
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n3 = new TreeNode(20,
                                   n4,
                                   n5);
        TreeNode n2 = new TreeNode(9);
        TreeNode n1 = new TreeNode(3,
                                   n2,
                                   n3);
        Lc404 lc404 = new Lc404();
        int res = lc404.sumOfLeftLeaves(n1);
        System.out.println("res = " + res);
    }
}
