package com.jacobcai.dccc;

import com.jacobcai.TreeNode;

public class Lc700_2 {
    public TreeNode searchBST(TreeNode root,
                              int val) {
        if (root == null || val == root.val) {
            return root;
        }
        return val < root.val ?
               searchBST(root.left,
                         val) :
               searchBST(root.right,
                         val);
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
        Lc700_2 lc700_2 = new Lc700_2();
        TreeNode res = lc700_2.searchBST(n4,
                                         val);
        System.out.println("res = " + res.val);
    }
}
