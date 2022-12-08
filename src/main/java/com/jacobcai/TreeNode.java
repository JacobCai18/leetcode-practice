package com.jacobcai;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {
    }
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val,
                    TreeNode left,
                    TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public static void print(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,
                res);
        System.out.println("res = " + res);
    }
    
    private static void inorder(TreeNode root,
                                List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left,
                res);
        res.add(root.val);
        inorder(root.right,
                res);
    }
}
