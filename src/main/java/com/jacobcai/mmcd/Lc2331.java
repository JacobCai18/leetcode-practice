package com.jacobcai.mmcd;

import com.jacobcai.TreeNode;

public class Lc2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) return root.val == 1;
        if (root.val == 2) return evaluateTree(root.left) || evaluateTree(root.right);
        return evaluateTree(root.left) && evaluateTree(root.right);
    }

    public static void main(String[] args) {
        Lc2331 lc2331 = new Lc2331();
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(0);
        TreeNode n1 = new TreeNode(2, n2, n3);
        boolean res = lc2331.evaluateTree(n1);
        System.out.println("res = " + res);
    }
}
