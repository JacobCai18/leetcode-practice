package com.jacobcai.dccc;

import com.jacobcai.TreeNode;

public class Lc700 {
    public TreeNode searchBST(TreeNode root,
                              int val) {
        while (root != null && val != root.val) {
            root = val < root.val ?
                   root.left :
                   root.right;
        }
        return root;
    }
    
    public static void main(String[] args) {
        int val = 2;
        TreeNode n1, n2, n3, n4, n7;
        n1 = new TreeNode(1);
        n3 = new TreeNode(3);
        n2 = new TreeNode(2,
                          n1,
                          n3);
        n7 = new TreeNode(7);
        n4 = new TreeNode(4,
                          n2,
                          n7);
        Lc700 lc700 = new Lc700();
        TreeNode res = lc700.searchBST(n4,
                                       val);
        System.out.println("res = " + res.val);
    }
}
