package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

public class Lc222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = 0;
        TreeNode node = root;
        while (node.left != null) {
            h++;
            node = node.left;
        }
        int le, ri;
        le = 1 << h;
        ri = (1 << (h + 1)) - 1;
        // [le, mid), [mid, ri]
        while (le < ri) {
            int mid = (le + ri + 1) >>> 1;
            if (exists(root,
                       h,
                       mid)) {
                le = mid;
            } else {
                ri = mid - 1;
            }
        }
        return le;
    }
    
    private boolean exists(TreeNode root,
                           int h,
                           int n) {
        // 从根向叶寻找
        int p = 1 << (h - 1);
        TreeNode node = root;
        while (node != null && p > 0) {
            if ((n & p) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            p >>= 1;
        }
        return node != null;
    }
    
    public static void main(String[] args) {
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2,
                                   n4,
                                   n5);
        TreeNode n3 = new TreeNode(3,
                                   n6,
                                   null);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   n3);
        Lc222 lc222 = new Lc222();
        int res = lc222.countNodes(n1);
        System.out.println("res = " + res);
    }
}
