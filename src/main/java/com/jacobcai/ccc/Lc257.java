package com.jacobcai.ccc;

import com.jacobcai.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lc257 {
    List<String> res;
    StringBuilder sb;
    
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        backtrack(root);
        return res;
    }
    
    private void backtrack(TreeNode root) {
        if (root == null) {
            return;
        }
        String s = String.valueOf(root.val);
        sb.append(s);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            backtrack(root.left);
            backtrack(root.right);
            sb.delete(sb.length() - 2,
                      sb.length());
        }
        sb.delete(sb.length() - s.length(),
                  sb.length());
    }
    
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(5);
        TreeNode n2 = new TreeNode(-2,
                                   null,
                                   n4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1,
                                   n2,
                                   n3);
        Lc257 lc257 = new Lc257();
        List<String> res = lc257.binaryTreePaths(n1);
        System.out.println("res = " + res);
    }
}
