package com.jacobcai.ci;

import com.jacobcai.TreeNode;

public class Lc114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
        flatten(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode n1, n2, n3;
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n1 = new TreeNode(1,
                          n2,
                          n3);
        Lc114 lc114 = new Lc114();
        lc114.flatten(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.right;
        }
    }
}
