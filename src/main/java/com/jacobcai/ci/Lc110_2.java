package com.jacobcai.ci;

import com.jacobcai.TreeNode;

public class Lc110_2 {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leH = height(root.left);
        if (leH == -1) {
            return -1;
        }
        int riH = height(root.right);
        if (riH == -1) {
            return -1;
        }
        return Math.abs(leH - riH) <= 1 ?
               Math.max(leH, riH) + 1 :
               -1;
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
        Lc110_2 lc110_2 = new Lc110_2();
        boolean res = lc110_2.isBalanced(n3);
        System.out.println("res = " + res);
    }
}
