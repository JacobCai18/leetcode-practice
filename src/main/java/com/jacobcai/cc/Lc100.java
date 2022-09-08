package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc100 {
    public boolean isSameTree(TreeNode p,
                              TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static void main(String[] args) {
        TreeNode n1, n2, n3;
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1,
                          n2,
                          n3);
        Lc100 lc100 = new Lc100();
        boolean res = lc100.isSameTree(n1,
                                       n1);
        System.out.println("res = " + res);
    }
}
