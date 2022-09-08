package com.jacobcai.cc;

import com.jacobcai.TreeNode;

public class Lc111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leDepth = minDepth(root.left);
        int riDepth = minDepth(root.right);
        if (leDepth == 0 || riDepth == 0) {
            return leDepth + riDepth + 1;
        }
        return Math.min(leDepth,
                        riDepth) + 1;
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
        Lc111 lc111 = new Lc111();
        int res = lc111.minDepth(n3);
        System.out.println("res = " + res);
    }
}
