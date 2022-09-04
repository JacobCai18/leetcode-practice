package com.jacobcai.c;

import com.jacobcai.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lc94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,
                res);
        return res;
    }
    
    private void inorder(TreeNode root,
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
    
    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3,
                                      node6,
                                      node7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2,
                                      node4,
                                      node5);
        TreeNode root = new TreeNode(1,
                                     node2,
                                     node3);
        Lc94 lc94 = new Lc94();
        List<Integer> res = lc94.inorderTraversal(root);
        System.out.println("res = " + res);
    }
}
