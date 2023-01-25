package com.jacobcai.dc;

import com.jacobcai.TreeNode;

public class Lc572 {
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return check(p.left, q.left) && check(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        Lc572 lc572 = new Lc572();
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);
        TreeNode n4 = new TreeNode(2);
        boolean res = lc572.isSubtree(n1, n4);
        System.out.println("res = " + res);
    }
}
