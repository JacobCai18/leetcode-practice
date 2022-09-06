package com.jacobcai.ci;

import com.jacobcai.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lc144 {
    List<Integer> res;
    
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        preorder(root);
        return res;
    }
    
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
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
        Lc144 lc144 = new Lc144();
        List<Integer> res = lc144.preorderTraversal(n4);
        System.out.println("res = " + res);
    }
}
