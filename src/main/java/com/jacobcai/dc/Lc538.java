package com.jacobcai.dc;

import com.jacobcai.TreeNode;

public class Lc538 {
    private int sum;
    
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
    
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n8 = new TreeNode(8);
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2,
                                   null,
                                   n3);
        TreeNode n1 = new TreeNode(1,
                                   n0,
                                   n2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7,
                                   null,
                                   n8);
        TreeNode n6 = new TreeNode(6,
                                   n5,
                                   n7);
        TreeNode n4 = new TreeNode(4,
                                   n1,
                                   n6);
        Lc538 lc538 = new Lc538();
        TreeNode res = lc538.convertBST(n4);
        TreeNode.print(res);
    }
}
