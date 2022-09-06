package com.jacobcai.ci;

import com.jacobcai.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lc145 {
    List<Integer> res;
    
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        preorder(root);
        return res;
    }
    
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        preorder(root.right);
        res.add(root.val);
    }
    
    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5, n6, n7;
        n7 = new TreeNode(7);
        n5 = new TreeNode(5);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1);
        n6 = new TreeNode(6,
                          n5,
                          n7);
        n2 = new TreeNode(2,
                          n1,
                          n3);
        n4 = new TreeNode(4,
                          n2,
                          n6);
        Lc145 lc145 = new Lc145();
        List<Integer> res = lc145.postorderTraversal(n4);
        System.out.println("res = " + res);
    }
}
